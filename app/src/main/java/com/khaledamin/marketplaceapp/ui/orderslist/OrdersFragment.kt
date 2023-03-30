package com.khaledamin.marketplaceapp.ui.orderslist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentOrdersBinding
import com.khaledamin.marketplaceapp.model.responses.Order
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel
import com.khaledamin.marketplaceapp.utils.ViewState
import com.khaledamin.marketplaceapp.utils.setInvisibleViews
import com.khaledamin.marketplaceapp.utils.setVisibleViews

class OrdersFragment : BaseFragmentWithViewModel<FragmentOrdersBinding, OrdersViewModel>(),
    OrderCallback {
    override val layout: Int
        get() = R.layout.fragment_orders
    override val viewModelClass: Class<OrdersViewModel>
        get() = OrdersViewModel::class.java

    private lateinit var ordersList: List<Order>
    private lateinit var ordersAdapter: OrdersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ordersAdapter = OrdersAdapter(ArrayList(), this)
        viewDataBinding.ordersList.adapter = ordersAdapter
        viewDataBinding.ordersList.layoutManager = LinearLayoutManager(requireContext())
        viewDataBinding.currentOrdersBtn.isEnabled = false
        viewDataBinding.previousOrdersBtn.isEnabled = true
        viewModel.getCurrentOrders(50, 1)

    }

    override fun setupListeners() {
        viewDataBinding.currentOrdersBtn.setOnClickListener {
            viewDataBinding.currentOrdersBtn.isEnabled = false
            viewDataBinding.previousOrdersBtn.isEnabled = true
            viewModel.getCurrentOrders(50, 1)
        }
        viewDataBinding.previousOrdersBtn.setOnClickListener {
            viewDataBinding.previousOrdersBtn.isEnabled = false
            viewDataBinding.currentOrdersBtn.isEnabled = true
            viewModel.getPreviousOrders(50, 1)
        }
        viewDataBinding.emptyViewButton.setOnClickListener {
            if (viewDataBinding.currentOrdersBtn.isEnabled) {
                viewModel.getPreviousOrders(50, 1)
            } else {
                viewModel.getCurrentOrders(50, 1)
            }
        }
    }

    override fun setupObservers() {
        viewModel.currentOrdersLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Loading -> loadingDialog.show()
                is ViewState.Success -> {
                    if (it.data!!.items!!.isEmpty()) {
                        viewDataBinding.emptyViewMessage.text =
                            getString(R.string.no_available_orders)
                        setInvisibleViews(viewDataBinding.ordersList,viewDataBinding.emptyViewButton)
                        setVisibleViews(viewDataBinding.emptyView)
                    } else {
                        setVisibleViews(viewDataBinding.ordersList)
                        setInvisibleViews(viewDataBinding.emptyView)
                        ordersList = it.data.items!!
                        ordersAdapter.updateDataSet(ordersList)
                    }
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    setVisibleViews(viewDataBinding.emptyView,viewDataBinding.emptyViewButton)
                    viewDataBinding.emptyViewMessage.text = getString(R.string.error_loading_orders)
                    setInvisibleViews(viewDataBinding.ordersList)
                }
            }
        })

        viewModel.previousOrdersLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Loading -> loadingDialog.show()
                is ViewState.Success -> {
                    if (it.data!!.items!!.isEmpty()) {
                        setVisibleViews(viewDataBinding.emptyView)
                        viewDataBinding.emptyViewMessage.text =
                            getString(R.string.no_available_orders)
                        setInvisibleViews(viewDataBinding.ordersList,viewDataBinding.emptyViewButton)
                    } else {
                        setVisibleViews(viewDataBinding.ordersList)
                        setInvisibleViews(viewDataBinding.emptyView)
                        ordersList = it.data.items!!
                        ordersAdapter.updateDataSet(ordersList)
                    }
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    setVisibleViews(viewDataBinding.emptyView,viewDataBinding.emptyViewButton)
                    viewDataBinding.emptyViewMessage.text = getString(R.string.error_loading_orders)
                    setInvisibleViews(viewDataBinding.ordersList)
                }
            }
        })
    }

    override fun onOrderClicked(order: Order) {
        findNavController().navigate(OrdersFragmentDirections.actionOrdersFragmentToOrderDetailsFragment(order))
    }

}
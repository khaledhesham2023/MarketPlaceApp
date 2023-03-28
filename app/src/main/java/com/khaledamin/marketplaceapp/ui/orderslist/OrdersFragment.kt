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
    }

    override fun setupObservers() {
        viewModel.currentOrdersLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Loading -> loadingDialog.show()
                is ViewState.Success -> {
                    ordersList = it.data!!.items!!
                    ordersAdapter.updateDataSet(ordersList)
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {

                }
            }
        })

        viewModel.previousOrdersLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Loading -> loadingDialog.show()
                is ViewState.Success -> {
                    ordersList = it.data!!.items!!
                    ordersAdapter.updateDataSet(ordersList)
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {

                }
            }
        })
    }

    override fun onOrderClicked(order: Order) {
        findNavController().navigate(OrdersFragmentDirections.actionOrdersFragmentToOrderDetailsFragment(order))
    }

}
package com.khaledamin.marketplaceapp.ui.notifications

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentNotificationsBinding
import com.khaledamin.marketplaceapp.model.responses.Notification
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel
import com.khaledamin.marketplaceapp.utils.ViewState

class NotificationsFragment :
    BaseFragmentWithViewModel<FragmentNotificationsBinding, NotificationsViewModel>() {
    override val layout: Int
        get() = R.layout.fragment_notifications
    override val viewModelClass: Class<NotificationsViewModel>
        get() = NotificationsViewModel::class.java

    private lateinit var notificationsAdapter: NotificationsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notificationsAdapter = NotificationsAdapter(ArrayList())
        viewDataBinding.notificationsList.adapter = notificationsAdapter
        viewDataBinding.notificationsList.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getNotifications()
    }

    override fun setupObservers() {
        viewModel.notificationsLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Loading -> {
                    loadingDialog.show()
                }
                is ViewState.Success -> {
                    if (it.data!!.isEmpty()) {
                        viewDataBinding.notificationsList.visibility = View.GONE
                        viewDataBinding.emptyView.visibility = View.VISIBLE
                        viewDataBinding.emptyViewButton.visibility = View.GONE
                        viewDataBinding.emptyViewMessage.text = getString(R.string.no_notifications)
                    } else {
                        viewDataBinding.notificationsList.visibility = View.VISIBLE
                        viewDataBinding.emptyView.visibility = View.GONE
                        notificationsAdapter.updateDataSet(it.data)
                    }
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    viewDataBinding.notificationsList.visibility = View.GONE
                    viewDataBinding.emptyView.visibility = View.VISIBLE
                    viewDataBinding.emptyViewButton.visibility = View.VISIBLE
                    viewDataBinding.emptyViewMessage.text =
                        getString(R.string.error_loading_notifications)
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun setupListeners() {
        viewDataBinding.emptyViewButton.setOnClickListener {
            viewModel.getNotifications()
        }
    }

}
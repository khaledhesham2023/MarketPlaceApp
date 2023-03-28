package com.khaledamin.marketplaceapp.ui.orderdetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentOrderDetailsBinding
import com.khaledamin.marketplaceapp.model.responses.Order
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel


class OrderDetailsFragment : BaseFragmentWithViewModel<FragmentOrderDetailsBinding,OrderDetailsViewModel>() {
    override val layout: Int
        get() = R.layout.fragment_order_details

    private var orderId:Long? = null
    override fun setupListeners() {
    }

    override val viewModelClass: Class<OrderDetailsViewModel>
        get() = OrderDetailsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        orderId = OrderDetailsFragmentArgs.fromBundle(requireArguments()).order!!.entityId
        Log.i("ORDER_ID",orderId.toString())
    }
    override fun setupObservers() {
    }

}
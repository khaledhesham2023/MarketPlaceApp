package com.khaledamin.marketplaceapp.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentCartBinding
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel

class CartFragment : BaseFragmentWithViewModel<FragmentCartBinding,CartViewModel>() {
    override val layout: Int
        get() = R.layout.fragment_cart
    override val viewModelClass: Class<CartViewModel>
        get() = CartViewModel::class.java

    override fun setupListeners() {
//        TODO("Not yet implemented")
    }

    override fun setupObservers() {
//        TODO("Not yet implemented")
    }

}
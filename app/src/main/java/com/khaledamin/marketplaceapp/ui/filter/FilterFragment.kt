package com.khaledamin.marketplaceapp.ui.filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentFilterBinding
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel


class FilterFragment : BaseFragmentWithViewModel<FragmentFilterBinding,FilterViewModel>() {
    override val layout: Int
        get() = R.layout.fragment_filter
    override val viewModelClass: Class<FilterViewModel>
        get() = FilterViewModel::class.java

    override fun setupListeners() {
//        TODO("Not yet implemented")
    }

    override fun setupObservers() {
//        TODO("Not yet implemented")
    }

}
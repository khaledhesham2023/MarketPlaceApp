package com.khaledamin.marketplaceapp.ui.base

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.khaledamin.marketplaceapp.datasource.remote.Repo.SharedPrefRepo
import com.khaledamin.marketplaceapp.ui.loading.LoadingDialog

abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {

    protected lateinit var viewDataBinding: VB

    abstract val layout: Int

    protected lateinit var loadingDialog: LoadingDialog

    protected lateinit var sharedPrefRepo: SharedPrefRepo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater,layout,container,false)
        loadingDialog = LoadingDialog(requireContext())
        sharedPrefRepo = SharedPrefRepo(requireContext())

        return viewDataBinding.root
    }
}
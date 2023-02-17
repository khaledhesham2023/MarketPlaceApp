package com.khaledamin.marketplaceapp.ui.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khaledamin.marketplaceapp.datasource.remote.Repo.SharedPrefRepo
import com.khaledamin.marketplaceapp.ui.loading.LoadingDialog

abstract class BaseActivityWithViewModel<VB : ViewDataBinding, VM : ViewModel> :
    BaseActivity<VB>() {

    protected lateinit var viewModel: VM

    abstract val viewModelClass: Class<VM>

    protected lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[viewModelClass]
        loadingDialog = LoadingDialog(this)
        setupListeners()
        setupObservers()
    }

    abstract fun setupObservers()

    abstract fun setupListeners()

}
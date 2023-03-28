package com.khaledamin.marketplaceapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.khaledamin.marketplaceapp.datasource.remote.Repo.SharedPrefRepo

abstract class BaseActivity<T: ViewDataBinding> : AppCompatActivity() {

    protected lateinit var viewDataBinding : T

    abstract val layout : Int

    protected lateinit var sharedPrefRepo: SharedPrefRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this,layout)
        sharedPrefRepo = SharedPrefRepo(this)
        initializeComponents()
    }

    abstract fun initializeComponents()
}


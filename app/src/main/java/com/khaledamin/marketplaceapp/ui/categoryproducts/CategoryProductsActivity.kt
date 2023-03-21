package com.khaledamin.marketplaceapp.ui.categoryproducts

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivityCategoryProductsBinding
import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse
import com.khaledamin.marketplaceapp.ui.base.BaseActivityWithViewModel
import com.khaledamin.marketplaceapp.ui.categories.CategoryCallback
import com.khaledamin.marketplaceapp.ui.categories.CategoryViewModel
import com.khaledamin.marketplaceapp.utils.Constants
import com.khaledamin.marketplaceapp.utils.ViewState

class CategoryProductsActivity :
    BaseActivityWithViewModel<ActivityCategoryProductsBinding, CategoryProductsViewModel>(),
    CategoryProductsCallback {
    override val layout: Int
        get() = R.layout.activity_category_products
    override val viewModelClass: Class<CategoryProductsViewModel>
        get() = CategoryProductsViewModel::class.java

    private lateinit var categoriesTabAdapter: CategoriesTabAdapter
    private lateinit var subCategoriesAdapter: SubCategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val categoryName = intent.getStringExtra(Constants.CATEGORY_NAME)
        categoriesTabAdapter = CategoriesTabAdapter(ArrayList(), this)
        subCategoriesAdapter = SubCategoriesAdapter(ArrayList())

        viewDataBinding.tabsList.adapter = categoriesTabAdapter
        viewDataBinding.tabsList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewDataBinding.subTabsList.adapter = subCategoriesAdapter
        viewDataBinding.subTabsList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewDataBinding.toolbarTitle.text = categoryName
        viewModel.getCategories()


    }

    override fun setupObservers() {
        viewModel.categoriesLiveData.observe(this, Observer {
            when (it) {
                is ViewState.Loading -> {
                    loadingDialog.show()
                }
                is ViewState.Success -> {
                    viewDataBinding.tabsList.visibility = View.VISIBLE
                    viewDataBinding.subTabsList.visibility = View.VISIBLE
                    viewDataBinding.emptyView.visibility = View.GONE
                    categoriesTabAdapter.updateDataSet(it.data!!.childrenData)
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    viewDataBinding.tabsList.visibility = View.GONE
                    viewDataBinding.subTabsList.visibility = View.GONE
                    viewDataBinding.emptyView.visibility = View.VISIBLE
                    viewDataBinding.emptyViewMessage.text = getString(R.string.error_loading_categories)
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun setupListeners() {
        viewDataBinding.backIcon.setOnClickListener {
            finish()
        }
        viewDataBinding.searchIcon.setOnClickListener {
            // TODO("Not yet implemented)
        }
        viewDataBinding.filterIcon.setOnClickListener {
            // TODO("Not yet implemented)
        }
    }

    override fun onCategoryClicked(category: GetCategoriesResponse) {
        viewDataBinding.toolbarTitle.text = category.name
        viewDataBinding.tabsList.smoothScrollToPosition(category.position!!)
        subCategoriesAdapter.updateDataSet(category.childrenData)
    }

}
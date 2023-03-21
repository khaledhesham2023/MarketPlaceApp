package com.khaledamin.marketplaceapp.ui.categories

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentCategoryBinding
import com.khaledamin.marketplaceapp.model.DataElement
import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel
import com.khaledamin.marketplaceapp.ui.categoryproducts.CategoryProductsActivity
import com.khaledamin.marketplaceapp.utils.Constants
import com.khaledamin.marketplaceapp.utils.ViewState

class CategoryFragment : BaseFragmentWithViewModel<FragmentCategoryBinding, CategoryViewModel>(),
    CategoryCallback {
    override val layout: Int
        get() = R.layout.fragment_category

    override val viewModelClass: Class<CategoryViewModel>
        get() = CategoryViewModel::class.java

    private lateinit var categoryAdapter: CategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryAdapter = CategoryAdapter(ArrayList(), this)
        viewDataBinding.categoriesList.adapter = categoryAdapter
        viewDataBinding.categoriesList.layoutManager = GridLayoutManager(requireContext(), 3)


    }

    override fun setupListeners() {
        viewDataBinding.emptyViewButton.setOnClickListener {
            viewModel.getCatalogs()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCatalogs()

    }
    override fun setupObservers() {
        viewModel.catalogsLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Loading -> loadingDialog.show()
                is ViewState.Success -> {
                    if (it.data!![1].dataElements!!.isEmpty()) {
                        viewDataBinding.emptyView.visibility= View.VISIBLE
                        viewDataBinding.emptyViewMessage.text =
                            getText(R.string.no_categories_available)
                        viewDataBinding.view.visibility = View.GONE
                        viewDataBinding.categoriesList.visibility = View.GONE
                    } else {
                        viewDataBinding.emptyView.visibility = View.GONE
                        viewDataBinding.view.visibility = View.VISIBLE
                        viewDataBinding.categoriesList.visibility = View.VISIBLE
                        categoryAdapter.updateDataSet(it.data[1].dataElements!!)
                    }

                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    viewDataBinding.emptyView.visibility = View.VISIBLE
                    viewDataBinding.view.visibility = View.GONE
                    viewDataBinding.categoriesList.visibility = View.GONE
                    viewDataBinding.emptyViewMessage.text =
                        getText(R.string.error_loading_categories)
                    loadingDialog.dismiss()
                }
            }
        })
    }


    override fun onCategoryClicked(category: DataElement) {
        val intent = Intent(requireActivity(), CategoryProductsActivity::class.java)
        intent.putExtra(Constants.CATEGORY_NAME, category.name)
        startActivity(intent)
    }

}
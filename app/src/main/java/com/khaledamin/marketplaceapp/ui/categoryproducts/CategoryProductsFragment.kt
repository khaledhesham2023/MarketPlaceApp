package com.khaledamin.marketplaceapp.ui.categoryproducts

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentCategoryProductsBinding
import com.khaledamin.marketplaceapp.model.DataElement
import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse
import com.khaledamin.marketplaceapp.model.responses.ProductItem
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel
import com.khaledamin.marketplaceapp.ui.productdetails.ProductsCallback
import com.khaledamin.marketplaceapp.utils.ViewState

class CategoryProductsFragment :
    BaseFragmentWithViewModel<FragmentCategoryProductsBinding, CategoryProductsViewModel>(),
    CategoryProductsCallback,ProductsCallback {
    override val layout: Int
        get() = R.layout.fragment_category_products
    override val viewModelClass: Class<CategoryProductsViewModel>
        get() = CategoryProductsViewModel::class.java

    private lateinit var categoriesTabAdapter: CategoriesTabAdapter
    private lateinit var subCategoriesAdapter: SubCategoriesAdapter
    private lateinit var productsAdapter: ProductsAdapter

    private var catalogId: Long? = null
    private lateinit var catalog: DataElement
    private lateinit var categoriesList: ArrayList<GetCategoriesResponse>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catalog = CategoryProductsFragmentArgs.fromBundle(requireArguments()).dataElement!!
        catalogId = catalog.id!!.toLong()
        requireActivity().title = catalog.name
        categoriesTabAdapter = CategoriesTabAdapter(ArrayList(), this)
        subCategoriesAdapter = SubCategoriesAdapter(ArrayList())
        productsAdapter = ProductsAdapter(ArrayList(),this)

        viewDataBinding.tabsList.adapter = categoriesTabAdapter
        viewDataBinding.tabsList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        viewDataBinding.subTabsList.adapter = subCategoriesAdapter
        viewDataBinding.subTabsList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        viewDataBinding.productsList.adapter = productsAdapter
        viewDataBinding.productsList.layoutManager = GridLayoutManager(requireContext(), 2)

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
                    categoriesList = it.data!!.childrenData
                    categoriesTabAdapter.updateDataSet(categoriesList)
                    categoriesTabAdapter.setCategorySelected(categoriesList, catalogId!!)
                    viewModel.getCategoryProducts( catalogId!!,50, 1)
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    viewDataBinding.tabsList.visibility = View.GONE
                    viewDataBinding.subTabsList.visibility = View.GONE
                    viewDataBinding.emptyView.visibility = View.VISIBLE
                    viewDataBinding.emptyViewMessage.text =
                        getString(R.string.error_loading_categories)
                    loadingDialog.dismiss()
                }

            }
        })

        viewModel.categoryProductsLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Loading -> {
                    loadingDialog.show()
                }
                is ViewState.Success -> {
                    if (it.data!!.items.isEmpty()) {
                        viewDataBinding.emptyView.visibility = View.VISIBLE
                        viewDataBinding.emptyViewMessage.text = getString(R.string.no_products_available)
                        viewDataBinding.productsList.visibility = View.GONE
                    } else {
                        viewDataBinding.emptyView.visibility = View.GONE
                        viewDataBinding.productsList.visibility = View.VISIBLE
                        productsAdapter.updateDataSet(it.data.items)
                        loadingDialog.dismiss()
                    }
                }
                is ViewState.Error -> {
                    viewDataBinding.productsList.visibility = View.GONE
                    viewDataBinding.emptyView.visibility = View.VISIBLE
                    viewDataBinding.emptyViewMessage.text =
                        it.message
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun setupListeners() {
        viewDataBinding.emptyViewButton.setOnClickListener {
            viewModel.getCategoryProducts(catalogId!!,50, 1)
        }
    }

    override fun onCategoryClicked(category: GetCategoriesResponse) {
        requireActivity().title = category.name
        subCategoriesAdapter.updateDataSet(category.childrenData)
        viewDataBinding.tabsList.smoothScrollToPosition(1)
        catalogId = category.id
        viewModel.getCategoryProducts(catalogId!!,50,1)
        Log.i("catalog",catalogId.toString())
    }

    override fun onProductClicked(sku: String?) {
        findNavController().navigate(CategoryProductsFragmentDirections.actionCategoryProductsFragmentToProductDetailsFragment(sku!!,catalogId!!))
    }


}
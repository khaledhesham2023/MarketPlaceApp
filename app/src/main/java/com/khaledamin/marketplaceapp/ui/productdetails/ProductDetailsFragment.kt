package com.khaledamin.marketplaceapp.ui.productdetails

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.snackbar.Snackbar
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentProductDetailsBinding
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel
import com.khaledamin.marketplaceapp.ui.categoryproducts.ProductsAdapter
import com.khaledamin.marketplaceapp.utils.ViewState

class ProductDetailsFragment :
    BaseFragmentWithViewModel<FragmentProductDetailsBinding, ProductsDetailsViewModel>(),ProductsCallback {
    override val layout: Int
        get() = R.layout.fragment_product_details
    override val viewModelClass: Class<ProductsDetailsViewModel>
        get() = ProductsDetailsViewModel::class.java

    private var sku: String? = null
    private var catalogId: Long? = null
    private lateinit var productsDetailsAdapter: ProductsDetailsAdapter
    private lateinit var productsAdapter: ProductsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sku = ProductDetailsFragmentArgs.fromBundle(requireArguments()).sku
        catalogId = ProductDetailsFragmentArgs.fromBundle(requireArguments()).catalogId
        productsDetailsAdapter = ProductsDetailsAdapter(ArrayList())
        productsAdapter = ProductsAdapter(ArrayList(), this)
        viewDataBinding.productFeaturesList.adapter = productsDetailsAdapter
        viewDataBinding.productFeaturesList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewDataBinding.otherProductsList.adapter = productsAdapter
        viewDataBinding.otherProductsList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        viewModel.getProductDetails(sku)
        viewModel.getCategoryProducts(catalogId!!, 50, 1)
    }

    override fun setupListeners() {
//        TODO("Not yet implemented")
    }

    override fun setupObservers() {
        viewModel.productsDetailsLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Loading -> {
                    loadingDialog.show()
                }
                is ViewState.Success -> {
                    viewDataBinding.productDetails = it.data
                    val list = arrayListOf<SlideModel>()
                    for (slide in it.data!!.mediaGallerySizes!!){
                        list.add(SlideModel(slide.full,null,ScaleTypes.FIT))
                    }
                    viewDataBinding.productSlider.setImageList(list)
                    productsDetailsAdapter.updateDataSet(it.data.specifications)
                    loadingDialog.dismiss()

                }
                is ViewState.Error -> {
                    Toast.makeText(requireContext(),
                        "Error during loading product features",
                        Toast.LENGTH_SHORT).show()
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
                    productsAdapter.updateDataSet(it.data!!.items)
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Snackbar.make(requireContext(),
                        viewDataBinding.root,
                        getString(R.string.error_loading_products),
                        Snackbar.LENGTH_LONG).show()
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun onProductClicked(sku: String?) {

    }


}
package com.khaledamin.marketplaceapp.ui.productdetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
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
    private lateinit var productsDetailsAdapter: ProductsDetailsAdapter
    private lateinit var productsAdapter: ProductsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sku = ProductDetailsFragmentArgs.fromBundle(requireArguments()).sku
        productsDetailsAdapter = ProductsDetailsAdapter(ArrayList())
        productsAdapter = ProductsAdapter(ArrayList(),this)
        viewDataBinding.productFeaturesList.adapter = productsDetailsAdapter
        viewDataBinding.productFeaturesList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewModel.getProductDetails(sku)
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
                    Toast.makeText(requireContext(),"Error during loading product features",Toast.LENGTH_SHORT).show()
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun onProductClicked(sku: String?) {

    }


}
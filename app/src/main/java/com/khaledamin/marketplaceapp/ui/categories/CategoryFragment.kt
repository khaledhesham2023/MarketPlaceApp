package com.khaledamin.marketplaceapp.ui.categories

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentCategoryBinding
import com.khaledamin.marketplaceapp.model.DataElement
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel
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
                    if (it.data!![0].dataElements!!.isEmpty()) {
                        viewDataBinding.emptySliderText.visibility = View.VISIBLE
                    } else {
                        viewDataBinding.emptySliderText.visibility = View.GONE
                        val list = arrayListOf<SlideModel>()
                        for (slide in it.data[0].dataElements!!){
                            list.add(SlideModel(slide.categoryThumbnail,slide.name,ScaleTypes.FIT))
                        }
                        viewDataBinding.sliderView.setImageList(list.toList())
                    }
                    if (it.data[1].dataElements!!.isEmpty()) {
                        viewDataBinding.emptyView.visibility = View.VISIBLE
                        viewDataBinding.emptyViewMessage.text =
                            getText(R.string.no_categories_available)
                        viewDataBinding.sliderView.visibility = View.GONE
                        viewDataBinding.categoriesList.visibility = View.GONE
                    } else {
                        viewDataBinding.emptyView.visibility = View.GONE
                        viewDataBinding.sliderView.visibility = View.VISIBLE
                        viewDataBinding.categoriesList.visibility = View.VISIBLE
                        categoryAdapter.updateDataSet(it.data[1].dataElements!!)
                    }

                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    viewDataBinding.emptyView.visibility = View.VISIBLE
                    viewDataBinding.sliderView.visibility = View.GONE
                    viewDataBinding.categoriesList.visibility = View.GONE
                    viewDataBinding.emptyViewMessage.text =
                        getText(R.string.error_loading_categories)
                    loadingDialog.dismiss()
                }
            }
        })
    }

    override fun onCategoryClicked(category: DataElement?) {
        findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToCategoryProductsFragment(
            category))

    }

}
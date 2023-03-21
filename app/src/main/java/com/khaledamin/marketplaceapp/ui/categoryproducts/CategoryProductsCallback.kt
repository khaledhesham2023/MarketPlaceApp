package com.khaledamin.marketplaceapp.ui.categoryproducts

import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse
import com.khaledamin.marketplaceapp.model.responses.ProductItem

interface CategoryProductsCallback {

    fun onCategoryClicked(category:GetCategoriesResponse)
}
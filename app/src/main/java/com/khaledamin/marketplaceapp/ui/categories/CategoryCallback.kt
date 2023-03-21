package com.khaledamin.marketplaceapp.ui.categories

import com.khaledamin.marketplaceapp.model.DataElement
import com.khaledamin.marketplaceapp.model.responses.Catalog
import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse

interface CategoryCallback {

    fun onCategoryClicked(category:DataElement)
}
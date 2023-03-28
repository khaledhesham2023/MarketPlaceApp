package com.khaledamin.marketplaceapp.ui.productdetails

import com.khaledamin.marketplaceapp.model.responses.ProductItem

interface ProductsCallback {
    fun onProductClicked(sku: String?)
}
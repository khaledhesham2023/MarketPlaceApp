package com.khaledamin.marketplaceapp.ui.orderslist

import com.khaledamin.marketplaceapp.model.responses.Order

interface OrderCallback {

    fun onOrderClicked(order: Order)
}
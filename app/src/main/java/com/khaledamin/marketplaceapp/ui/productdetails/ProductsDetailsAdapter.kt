package com.khaledamin.marketplaceapp.ui.productdetails

import android.view.ViewGroup
import android.widget.GridLayout.Spec
import androidx.recyclerview.widget.RecyclerView
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ItemProductDetailsBinding
import com.khaledamin.marketplaceapp.model.Specification
import com.khaledamin.marketplaceapp.model.responses.GetProductDetailsResponse
import com.khaledamin.marketplaceapp.ui.base.BaseAdapter

class ProductsDetailsAdapter(data:ArrayList<Specification>):BaseAdapter<Specification,ItemProductDetailsBinding,ProductsDetailsAdapter.ProductDetailsViewHolder>(data) {

    inner class ProductDetailsViewHolder(val binding: ItemProductDetailsBinding):RecyclerView.ViewHolder(binding.root){

    }

    override val layout: Int
        get() = R.layout.item_product_details

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailsViewHolder {
        return ProductDetailsViewHolder(getItemViewBinding(parent))
    }

    override fun onBindViewHolder(holder: ProductDetailsViewHolder, position: Int) {
        holder.binding.specification = data[position]
    }
}
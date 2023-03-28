package com.khaledamin.marketplaceapp.ui.categoryproducts

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ItemProductBinding
import com.khaledamin.marketplaceapp.model.responses.ProductItem
import com.khaledamin.marketplaceapp.ui.base.BaseAdapter
import com.khaledamin.marketplaceapp.ui.productdetails.ProductsCallback

class ProductsAdapter(data: ArrayList<ProductItem>,private val callback: ProductsCallback) :
    BaseAdapter<ProductItem, ItemProductBinding, ProductsAdapter.ProductsViewHolder>(data) {

    inner class ProductsViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
            init {
                binding.root.setOnClickListener {
                    callback.onProductClicked(data[layoutPosition].sku)
                }
            }
    }

    override val layout: Int
        get() = R.layout.item_product

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(getItemViewBinding(parent))
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.binding.product = data[position]
    }
}
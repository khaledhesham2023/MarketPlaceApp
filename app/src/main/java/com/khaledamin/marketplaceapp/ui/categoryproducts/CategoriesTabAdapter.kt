package com.khaledamin.marketplaceapp.ui.categoryproducts

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ItemCategory2Binding
import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse
import com.khaledamin.marketplaceapp.ui.base.BaseAdapter
import com.khaledamin.marketplaceapp.ui.categories.CategoryCallback

class CategoriesTabAdapter(
    data: List<GetCategoriesResponse>,
    private val callback: CategoryProductsCallback,
) :
    BaseAdapter<GetCategoriesResponse, ItemCategory2Binding, CategoriesTabAdapter.CategoriesTabViewHolder>(
        data) {

    private var selectedCategory: GetCategoriesResponse? = null

    inner class CategoriesTabViewHolder(val binding: ItemCategory2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if (selectedCategory != null){
                    selectedCategory!!.isSelected = false
                }
                selectedCategory = data[layoutPosition]
                selectedCategory!!.isSelected = true
                callback.onCategoryClicked(selectedCategory!!)
                notifyDataSetChanged()
            }
        }

    }

    override val layout: Int
        get() = R.layout.item_category2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesTabViewHolder {
        return CategoriesTabViewHolder(getItemViewBinding(parent))
    }

    override fun onBindViewHolder(holder: CategoriesTabViewHolder, position: Int) {
        val category = data[position]
        holder.binding.categoryItem = category
        if (category.isSelected){
            holder.binding.tabLine.visibility = View.VISIBLE
        } else {
            holder.binding.tabLine.visibility = View.INVISIBLE

        }
    }
}
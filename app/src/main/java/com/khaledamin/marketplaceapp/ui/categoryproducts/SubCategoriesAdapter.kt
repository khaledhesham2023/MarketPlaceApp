package com.khaledamin.marketplaceapp.ui.categoryproducts

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ItemCategory3Binding
import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse
import com.khaledamin.marketplaceapp.ui.base.BaseAdapter

class SubCategoriesAdapter(data:ArrayList<GetCategoriesResponse>):BaseAdapter<GetCategoriesResponse,ItemCategory3Binding,SubCategoriesAdapter.SubCategoriesViewHolder>(data) {

    inner class SubCategoriesViewHolder(val binding:ItemCategory3Binding):RecyclerView.ViewHolder(binding.root){

    }

    override val layout: Int
        get() = R.layout.item_category3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoriesViewHolder {
        return SubCategoriesViewHolder(getItemViewBinding(parent))
    }

    override fun onBindViewHolder(holder: SubCategoriesViewHolder, position: Int) {
        holder.binding.categoryItem = data[position]
    }

}
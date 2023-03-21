package com.khaledamin.marketplaceapp.ui.categories

import android.provider.ContactsContract.Data
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ItemCategoryBinding
import com.khaledamin.marketplaceapp.model.DataElement
import com.khaledamin.marketplaceapp.model.responses.Catalog
import com.khaledamin.marketplaceapp.model.responses.GetCategoriesResponse
import com.khaledamin.marketplaceapp.ui.base.BaseAdapter

class CategoryAdapter(
    data: ArrayList<DataElement>,
    private val callback: CategoryCallback,
) :
    BaseAdapter<DataElement, ItemCategoryBinding, CategoryAdapter.CategoryViewHolder>(data) {

    override val layout: Int
        get() = R.layout.item_category

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        Log.i("TAGG","onCreateViewHolder")
        return CategoryViewHolder(getItemViewBinding(parent))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        Log.i("TAGG","onBindViewHolder")
        holder.binding.dataElement = data[position]
    }

    inner class CategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            Log.i("TAGG","INIT")
            binding.root.setOnClickListener {
                callback.onCategoryClicked(data[layoutPosition])
            }
        }
    }
}
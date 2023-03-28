package com.khaledamin.marketplaceapp.ui.orderslist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ItemOrderBinding
import com.khaledamin.marketplaceapp.model.responses.Order
import com.khaledamin.marketplaceapp.ui.base.BaseAdapter

class OrdersAdapter(data: ArrayList<Order>, private val callback: OrderCallback) :
    BaseAdapter<Order, ItemOrderBinding, OrdersAdapter.OrdersViewHolder>(data) {
    inner class OrdersViewHolder(val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.orderDetailsBtn.setOnClickListener {
                callback.onOrderClicked(data[layoutPosition])
            }
        }
    }

    override val layout: Int
        get() = R.layout.item_order

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        return OrdersViewHolder(getItemViewBinding(parent))
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        holder.binding.order = data[position]
    }
}
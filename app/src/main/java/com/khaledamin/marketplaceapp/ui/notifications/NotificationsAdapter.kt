package com.khaledamin.marketplaceapp.ui.notifications

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ItemNotificationBinding
import com.khaledamin.marketplaceapp.model.responses.Notification
import com.khaledamin.marketplaceapp.ui.base.BaseAdapter

class NotificationsAdapter(data:ArrayList<Notification>):BaseAdapter<Notification,ItemNotificationBinding,NotificationsAdapter.NotificationsViewHolder>(data) {

    inner class NotificationsViewHolder(val binding:ItemNotificationBinding):RecyclerView.ViewHolder(binding.root){

    }

    override val layout: Int = R.layout.item_notification

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsViewHolder {
        return NotificationsViewHolder(getItemViewBinding(parent))
    }

    override fun onBindViewHolder(holder: NotificationsViewHolder, position: Int) {
        holder.binding.notification = data[position]
    }
}
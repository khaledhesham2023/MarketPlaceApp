package com.khaledamin.marketplaceapp.ui.base

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VB:ViewDataBinding, VH : RecyclerView.ViewHolder>(protected var data: List<T>) :
    RecyclerView.Adapter<VH>() {

    override fun getItemCount(): Int = data.size

    abstract val layout:Int

    protected open fun getItemViewBinding(parent:ViewGroup):VB{
        Log.i("TAGG","getItemViewBinding")
        return DataBindingUtil.inflate(LayoutInflater.from(parent.context),layout,parent,false)
    }

    open fun updateDataSet(data:List<T>){
        Log.i("TAGG","updateDataSet")
        this.data = data
        notifyDataSetChanged()
    }
}
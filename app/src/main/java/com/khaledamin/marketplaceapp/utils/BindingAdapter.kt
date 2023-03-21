package com.khaledamin.marketplaceapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.khaledamin.marketplaceapp.R

@BindingAdapter("imgUrl")
fun convertImageUrlIntoImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url).placeholder(R.drawable.marketplacelogo2).into(imageView)
}
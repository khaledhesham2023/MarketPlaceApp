package com.khaledamin.marketplaceapp.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentCategoryBinding
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel

class CategoryFragment : BaseFragmentWithViewModel<FragmentCategoryBinding, CategoryViewModel>() {
    override val layout: Int
        get() = R.layout.fragment_category

    override val viewModelClass: Class<CategoryViewModel>
        get() = CategoryViewModel::class.java

}
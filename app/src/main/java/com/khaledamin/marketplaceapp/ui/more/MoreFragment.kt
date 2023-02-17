package com.khaledamin.marketplaceapp.ui.more

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentMoreBinding
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel

class MoreFragment : BaseFragmentWithViewModel<FragmentMoreBinding,MoreViewModel>() {
    override val layout: Int
        get() = R.layout.fragment_more
    override val viewModelClass: Class<MoreViewModel>
        get() = MoreViewModel::class.java

}
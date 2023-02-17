package com.khaledamin.marketplaceapp.ui.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentAccountBinding
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel


class AccountFragment : BaseFragmentWithViewModel<FragmentAccountBinding,AccountViewModel>() {
    override val layout: Int
        get() = R.layout.fragment_account
    override val viewModelClass: Class<AccountViewModel>
        get() = AccountViewModel::class.java


}
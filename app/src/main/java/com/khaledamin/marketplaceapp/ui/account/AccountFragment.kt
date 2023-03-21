package com.khaledamin.marketplaceapp.ui.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentAccountBinding
import com.khaledamin.marketplaceapp.ui.authentication.login.LoginActivity
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel
import com.khaledamin.marketplaceapp.utils.showConfirmationDialog


class AccountFragment : BaseFragmentWithViewModel<FragmentAccountBinding,AccountViewModel>() {
    override val layout: Int
        get() = R.layout.fragment_account
    override val viewModelClass: Class<AccountViewModel>
        get() = AccountViewModel::class.java


    override fun setupListeners() {
        viewDataBinding.signout.setOnClickListener {
        logout()
    }
    }

    override fun setupObservers() {
//        TODO("Not yet implemented")
    }
    private fun logout(){
        showConfirmationDialog(requireContext(),R.string.confirmation,R.string.confirm_logout,R.string.logout,R.string.cancel){
            _,_ ->
            sharedPrefRepo.setBearerToken(null)
            sharedPrefRepo.setLoggedIn(false)
            sharedPrefRepo.saveUser(null)
            startActivity(Intent(requireActivity(),LoginActivity::class.java))
            requireActivity().finish()
        }
        }

    }



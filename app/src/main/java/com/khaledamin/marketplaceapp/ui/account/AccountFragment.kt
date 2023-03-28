package com.khaledamin.marketplaceapp.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentAccountBinding
import com.khaledamin.marketplaceapp.ui.authentication.login.LoginActivity
import com.khaledamin.marketplaceapp.ui.base.BaseFragment
import com.khaledamin.marketplaceapp.utils.showConfirmationDialog


class AccountFragment : BaseFragment<FragmentAccountBinding>() {
    override val layout: Int
        get() = R.layout.fragment_account

    override fun onResume() {
        super.onResume()
        viewDataBinding.name.text =
            "${sharedPrefRepo.getUser().firstName} ${sharedPrefRepo.getUser().lastName}"
        viewDataBinding.email.text = sharedPrefRepo.getUser().email
    }

    override fun setupListeners() {
        viewDataBinding.logoutLayout.setOnClickListener {
            logout()
        }
        viewDataBinding.ordersGroup.setOnClickListener {
            findNavController().navigate(AccountFragmentDirections.actionAccountFragmentToOrdersFragment())
        }
        viewDataBinding.settingsGroup.setOnClickListener {
            findNavController().navigate(AccountFragmentDirections.actionAccountFragmentToEditAccountFragment())
        }
    }

    private fun logout(){
        showConfirmationDialog(requireContext(),R.string.confirmation,R.string.confirm_logout,R.string.logout,R.string.cancel) { _, _ ->
            sharedPrefRepo.setBearerToken(null)
            sharedPrefRepo.setLoggedIn(false)
            sharedPrefRepo.saveUser(null)
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
            requireActivity().finish()
        }
    }
        }




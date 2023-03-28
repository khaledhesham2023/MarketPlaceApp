package com.khaledamin.marketplaceapp.ui.editaccount

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.FragmentEditAccountBinding
import com.khaledamin.marketplaceapp.model.CustomAttribute
import com.khaledamin.marketplaceapp.model.Customer
import com.khaledamin.marketplaceapp.model.requests.EditProfileRequest
import com.khaledamin.marketplaceapp.ui.authentication.password.PasswordActivity
import com.khaledamin.marketplaceapp.ui.base.BaseFragmentWithViewModel
import com.khaledamin.marketplaceapp.utils.ViewState


class EditAccountFragment :
    BaseFragmentWithViewModel<FragmentEditAccountBinding, EditAccountViewModel>() {
    override val layout: Int
        get() = R.layout.fragment_edit_account

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProfile()
    }

    override fun onResume() {
        super.onResume()
        val password = sharedPrefRepo.getPassword()
        viewDataBinding.password.setText(password)

    }

    override fun setupListeners() {
        viewDataBinding.changePasswordBtn.setOnClickListener {
            requireActivity().startActivity(Intent(requireActivity(), PasswordActivity::class.java))
        }
        viewDataBinding.save.setOnClickListener {
            val number = viewDataBinding.customerPhone.text.toString()
            val numberEntry = if (number.startsWith('0')) {
                number.trim('0')
            } else {
                number
            }
            val request = EditProfileRequest(Customer(arrayListOf(
                CustomAttribute("customer_mobile", numberEntry),
                CustomAttribute("registered_software", "android"),
                CustomAttribute("customer_mobile_code", "02"),
                CustomAttribute("registered_by", ""),
                CustomAttribute("social_id", "")),
                viewDataBinding.customerEmail.text.toString().trim(),
                viewDataBinding.customerFirstname.text.toString().trim(),
                viewDataBinding.customerLastname.text.toString().trim(),
                1))
            viewModel.editProfile(request)
        }

    }

    override val viewModelClass: Class<EditAccountViewModel>
        get() = EditAccountViewModel::class.java

    override fun setupObservers() {
        viewModel.getProfileLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Loading -> {
                    loadingDialog.show()
                }
                is ViewState.Success -> {
                    viewDataBinding.user = it.data
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Toast.makeText(requireContext(),
                        "Error during loading user data",
                        Toast.LENGTH_SHORT).show()
                    loadingDialog.dismiss()
                }
            }
        })

        viewModel.editProfileLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Loading -> {
                    loadingDialog.show()
                }
                is ViewState.Success -> {
                    sharedPrefRepo.saveUser(it.data)
                    Toast.makeText(requireContext(),
                        getString(R.string.profile_edit_success),
                        Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                    loadingDialog.dismiss()
                }
                is ViewState.Error -> {
                    Toast.makeText(requireContext(),
                        "Error during editing user data",
                        Toast.LENGTH_SHORT).show()
                    loadingDialog.dismiss()
                }

            }
        })
    }


}
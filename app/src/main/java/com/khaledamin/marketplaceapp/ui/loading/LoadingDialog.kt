package com.khaledamin.marketplaceapp.ui.loading

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.khaledamin.marketplaceapp.R

class LoadingDialog(context: Context) : Dialog(context) {
    init {
        setContentView(R.layout.progress)
        setCancelable(false)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun show() {
        if (!isShowing){
            super.show()

        }
    }

    override fun dismiss() {
        if(isShowing){
            super.dismiss()
        }
    }
}
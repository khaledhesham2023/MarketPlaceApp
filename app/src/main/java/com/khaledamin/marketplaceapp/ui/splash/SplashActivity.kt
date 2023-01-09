package com.khaledamin.marketplaceapp.ui.splash

import android.content.Intent
import android.view.View
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivitySplashBinding
import com.khaledamin.marketplaceapp.ui.base.BaseActivity
import com.khaledamin.marketplaceapp.ui.login.LoginActivity
import pl.droidsonroids.gif.GifDrawable

class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override val layout: Int
        get() = R.layout.activity_splash

    override fun onResume() {
        super.onResume()
        startSplash()

    }

    private fun startSplash() {
        val gifFromResources = GifDrawable(resources, R.drawable.marketplacelogo)
        android.os.Handler().postDelayed(Runnable {
            gifFromResources.loopCount = 3

        },3000)
        android.os.Handler().postDelayed(Runnable {
            viewDataBinding.splashWheel.visibility = View.VISIBLE
        },4000)
        android.os.Handler().postDelayed(Runnable {
            viewDataBinding.splashWheel.visibility = View.GONE
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }, 7000)
    }

}

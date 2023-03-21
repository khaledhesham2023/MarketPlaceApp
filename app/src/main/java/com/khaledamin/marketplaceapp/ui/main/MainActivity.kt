package com.khaledamin.marketplaceapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivityMainBinding
import com.khaledamin.marketplaceapp.ui.base.BaseActivity
import com.khaledamin.marketplaceapp.ui.notifications.NotificationsActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layout: Int
        get() = R.layout.activity_main

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
                .findNavController()

        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.categoryFragment,
            R.id.cartFragment,
            R.id.accountFragment,
            R.id.moreFragment
        ).build()

        setSupportActionBar(viewDataBinding.toolbar)

        this.title = ""

        viewDataBinding.toolbar.setupWithNavController(navController, appBarConfiguration)

        viewDataBinding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.cartFragment -> {
                    viewDataBinding.toolbarTitle.text = getString(R.string.cart)
                }
                R.id.categoryFragment -> {
                    viewDataBinding.toolbarTitle.text = getString(R.string.categories)
                }
                R.id.accountFragment -> {
                    viewDataBinding.toolbarTitle.text = getString(R.string.account)
                }
                R.id.moreFragment -> {
                    viewDataBinding.toolbarTitle.text = getString(R.string.more)
                }

            }
        }

        viewDataBinding.notificationIcon.setOnClickListener {
            startActivity(Intent(this@MainActivity, NotificationsActivity::class.java))
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
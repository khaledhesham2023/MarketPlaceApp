package com.khaledamin.marketplaceapp.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.khaledamin.marketplaceapp.NavigationDirections
import com.khaledamin.marketplaceapp.R
import com.khaledamin.marketplaceapp.databinding.ActivityMainBinding
import com.khaledamin.marketplaceapp.ui.base.BaseActivity
import com.khaledamin.marketplaceapp.utils.setIconsGone
import com.khaledamin.marketplaceapp.utils.setIconsVisible
import com.khaledamin.marketplaceapp.utils.setInvisibleViews
import com.khaledamin.marketplaceapp.utils.setVisibleViews

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layout: Int
        get() = R.layout.activity_main

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var optionsMenu: Menu


    override fun initializeComponents() {
        navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
                .findNavController()

        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.categoryFragment,
            R.id.cartFragment,
            R.id.accountFragment,
            R.id.moreFragment
        ).build()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(viewDataBinding.toolbar)

        viewDataBinding.toolbar.setupWithNavController(navController, appBarConfiguration)
        viewDataBinding.bottomNavigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        optionsMenu = menu!!
        setupDestinationListeners()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.notifications_icon -> {
                navController.navigate(NavigationDirections.actionGlobalNotificationsFragment())
            }
            R.id.filter_icon -> {
                navController.navigate(NavigationDirections.actionGlobalFilterFragment())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupDestinationListeners() {
        navController.addOnDestinationChangedListener { _, destination, _ ->

            // Configurations of Notification Screen
            when (destination.id) {
                R.id.notificationsFragment -> {
                    setVisibleViews(viewDataBinding.appbarLayout)
                    setInvisibleViews(viewDataBinding.bottomNavigationView)
                    setIconsGone(optionsMenu,
                        R.id.notifications_icon,
                        R.id.filter_icon,
                        R.id.search_icon,
                        R.id.cart_icon)
                }
                R.id.categoryProductsFragment -> {
                    setVisibleViews(viewDataBinding.appbarLayout)
                    setInvisibleViews(viewDataBinding.bottomNavigationView)
                    setIconsGone(optionsMenu, R.id.notifications_icon, R.id.cart_icon)
                    setIconsVisible(optionsMenu, R.id.search_icon, R.id.filter_icon)
                }
                R.id.filterFragment -> {
                    setVisibleViews(viewDataBinding.appbarLayout)
                    setInvisibleViews(viewDataBinding.bottomNavigationView)
                    setIconsGone(optionsMenu,
                        R.id.notifications_icon,
                        R.id.filter_icon,
                        R.id.search_icon,
                        R.id.cart_icon)
                }
                R.id.categoryFragment -> {
                    this.title = getString(R.string.categories)
                    setVisibleViews(viewDataBinding.appbarLayout,
                        viewDataBinding.bottomNavigationView)
                    setIconsGone(optionsMenu, R.id.filter_icon, R.id.cart_icon)
                    setIconsVisible(optionsMenu, R.id.search_icon, R.id.notifications_icon)

                }
                R.id.editAccountFragment -> {
                    setInvisibleViews(viewDataBinding.appbarLayout,viewDataBinding.bottomNavigationView)
                }
                R.id.productDetailsFragment -> {
                    setVisibleViews(viewDataBinding.appbarLayout)
                    setIconsVisible(optionsMenu, R.id.cart_icon)
                    setIconsGone(optionsMenu, R.id.filter_icon, R.id.search_icon)
                }
                R.id.cartFragment -> {
                    setVisibleViews(viewDataBinding.appbarLayout)
                    setIconsGone(optionsMenu,
                        R.id.notifications_icon,
                        R.id.filter_icon,
                        R.id.search_icon,
                        R.id.cart_icon)
                }
                R.id.accountFragment -> {
                    setInvisibleViews(viewDataBinding.appbarLayout)
                }
                R.id.ordersFragment -> {
                    setVisibleViews(viewDataBinding.appbarLayout)
                    setInvisibleViews(viewDataBinding.bottomNavigationView)
                    setIconsGone(optionsMenu,
                        R.id.notifications_icon,
                        R.id.filter_icon,
                        R.id.search_icon,
                        R.id.cart_icon)
                }
            }
        }

    }

}
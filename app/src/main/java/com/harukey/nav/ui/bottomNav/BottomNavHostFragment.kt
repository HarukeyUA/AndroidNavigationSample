package com.harukey.nav.ui.bottomNav

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.harukey.nav.R
import com.harukey.nav.di.BottomNavHostDispatcher
import com.harukey.nav.extensions.observe
import com.harukey.nav.utils.NavigationDispatcher
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BottomNavHostFragment : Fragment(R.layout.bottom_nav_host_fragment) {

    @BottomNavHostDispatcher
    @Inject
    lateinit var navDispatcher: NavigationDispatcher

    private val navHost: NavHostFragment by lazy {
        childFragmentManager.findFragmentById(R.id.navContainer) as NavHostFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupNavBar(view)
        handleChildNavigation()
    }

    private fun setupNavBar(view: View) {
        view.findViewById<BottomNavigationView>(R.id.bottomNavBar)
            .setupWithNavController(navHost.navController)
    }

    private fun handleChildNavigation() {
        observe(navDispatcher.navigationCommandEvents) {
            it.invoke(navHost.navController)
        }
    }
}

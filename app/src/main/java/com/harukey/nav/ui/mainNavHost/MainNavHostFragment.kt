package com.harukey.nav.ui.mainNavHost

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.harukey.nav.R
import com.harukey.nav.di.MainNavHostNavDispatcher
import com.harukey.nav.extensions.observe
import com.harukey.nav.utils.NavigationDispatcher
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainNavHostFragment : Fragment(R.layout.main_nav_host_fragment) {

    private val viewModel: MainNavHostViewModel by viewModels()

    @MainNavHostNavDispatcher
    @Inject
    lateinit var navigationDispatcher: NavigationDispatcher

    private val navHost: NavHostFragment by lazy {
        childFragmentManager.findFragmentById(R.id.mainNavContainer) as NavHostFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNavGraph()
        handleNavigation()
    }

    private fun initNavGraph() {
        val navGraph =
            navHost.navController.navInflater.inflate(R.navigation.main_nav_graph).apply {
                setStartDestination(
                    if (viewModel.isLoggedIn()) {
                        R.id.bottomNavHostFragment
                    } else {
                        R.id.loginFragment
                    }
                )
            }
        navHost.navController.graph = navGraph
    }

    private fun handleNavigation() {
        observe(navigationDispatcher.navigationCommandEvents) {
            it.invoke(navHost.navController)
        }
    }
}

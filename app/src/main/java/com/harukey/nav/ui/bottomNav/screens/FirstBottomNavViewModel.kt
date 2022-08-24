package com.harukey.nav.ui.bottomNav.screens

import androidx.lifecycle.ViewModel
import com.harukey.nav.di.MainNavHostNavDispatcher
import com.harukey.nav.ui.bottomNav.BottomNavHostFragmentDirections
import com.harukey.nav.utils.NavigationDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstBottomNavViewModel @Inject constructor(
    @MainNavHostNavDispatcher private val navigationDispatcher: NavigationDispatcher
) : ViewModel() {

    fun navigate() {
        navigationDispatcher.navigate {
            it.navigate(BottomNavHostFragmentDirections.actionBottomNavHostFragmentToTestFragment2())
        }
    }
}

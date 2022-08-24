package com.harukey.nav.ui.bottomNav.screens

import androidx.lifecycle.ViewModel
import com.harukey.nav.di.BottomNavHostDispatcher
import com.harukey.nav.utils.NavigationDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThirdBottomNavViewModel @Inject constructor(
    @BottomNavHostDispatcher private val dispatcher: NavigationDispatcher
): ViewModel() {

    fun navigateFurther() {
        dispatcher.navigate {
            it.navigate(ThirdBottomNavFragmentDirections.actionThirdBottomNavFragmentToTestFragment())
        }
    }
}

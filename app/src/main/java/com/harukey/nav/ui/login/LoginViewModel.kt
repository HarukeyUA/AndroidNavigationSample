package com.harukey.nav.ui.login

import androidx.lifecycle.ViewModel
import com.harukey.nav.data.PreferenceProvider
import com.harukey.nav.R
import com.harukey.nav.di.MainNavHostNavDispatcher
import com.harukey.nav.extensions.popUpToCurrent
import com.harukey.nav.utils.NavigationDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    @MainNavHostNavDispatcher private val mainNavigationDispatcher: NavigationDispatcher,
    private val preferences: PreferenceProvider
) : ViewModel() {

    fun onLoginClicked() {
        preferences.isLoggedIn = true
        navigateToBottomNavScreen()
    }

    private fun navigateToBottomNavScreen() {
        mainNavigationDispatcher.navigate {
            it.navigate(
                resId = R.id.bottomNavHostFragment,
                args = null,
                navOptions = it.popUpToCurrent()
            )
        }
    }
}

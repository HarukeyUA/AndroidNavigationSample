package com.harukey.nav.ui.mainNavHost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harukey.nav.data.PreferenceProvider
import com.harukey.nav.R
import com.harukey.nav.di.MainNavHostNavDispatcher
import com.harukey.nav.extensions.popUpToCurrent
import com.harukey.nav.utils.NavigationDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainNavHostViewModel @Inject constructor(
    private val preferences: PreferenceProvider,
    @MainNavHostNavDispatcher private val navigationDispatcher: NavigationDispatcher
) : ViewModel() {

    init {
        viewModelScope.launch {
            preferences.getIsLoggedInFlow().collect { isLoggedIn ->
                if (!isLoggedIn) {
                    navigateToLogin()
                }
            }
        }

    }

    private fun navigateToLogin() {
        navigationDispatcher.navigate { navController ->
            navController.navigate(
                R.id.loginFragment,
                null,
                navController.popUpToCurrent()
            )
        }
    }

    fun isLoggedIn(): Boolean {
        return preferences.isLoggedIn
    }
}

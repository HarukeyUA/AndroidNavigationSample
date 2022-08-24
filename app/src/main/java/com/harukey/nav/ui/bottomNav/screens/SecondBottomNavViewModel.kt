package com.harukey.nav.ui.bottomNav.screens

import androidx.lifecycle.ViewModel
import com.harukey.nav.data.PreferenceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondBottomNavViewModel @Inject constructor(
    private val preferenceProvider: PreferenceProvider
) : ViewModel() {

    fun logOff() {
        preferenceProvider.isLoggedIn = false
    }
}

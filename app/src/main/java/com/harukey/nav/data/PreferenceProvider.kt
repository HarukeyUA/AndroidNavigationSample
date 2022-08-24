package com.harukey.nav.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceProvider @Inject constructor(@ApplicationContext context: Context) {

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE)
    }

    var isLoggedIn: Boolean
        get() = preferences.getBoolean(IS_LOGGED_IN, false)
        set(value) = preferences.edit {
            putBoolean(IS_LOGGED_IN, value)
        }

    fun getIsLoggedInFlow() = callbackFlow {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            if (key == IS_LOGGED_IN) {
                trySend(isLoggedIn)
            }
        }
        trySend(isLoggedIn)
        preferences.registerOnSharedPreferenceChangeListener(listener)
        awaitClose {
            preferences.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }


    companion object {
        private const val PREFERENCE_FILE = "nav_preferences"
        private const val IS_LOGGED_IN = "is_logged_in"
    }
}

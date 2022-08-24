package com.harukey.nav.extensions

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.navOptions

fun NavController.popUpToCurrent(): NavOptions {
    return navOptions {
        currentDestination?.id?.also {
            popUpTo(it) {
                inclusive = true
            }
        }
    }
}

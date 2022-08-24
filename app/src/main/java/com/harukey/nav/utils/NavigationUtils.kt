package com.harukey.nav.utils

import androidx.navigation.NavController
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

typealias NavigationCommand = (NavController) -> Unit

class NavigationDispatcher {
    private val navigationChannel = Channel<NavigationCommand>(Channel.UNLIMITED)
    val navigationCommandEvents = navigationChannel.receiveAsFlow()

    fun navigate(navigationCommand: NavigationCommand) {
        navigationChannel.trySend(navigationCommand)
    }
}

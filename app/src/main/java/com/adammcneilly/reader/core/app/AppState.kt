package com.adammcneilly.reader.core.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.staticCompositionLocalOf
import com.adammcneilly.reader.core.displaymodels.NavigationItemDisplayModel

val LocalAppState = staticCompositionLocalOf<AppState> {
    throw IllegalArgumentException("AppState must be provided in the app scaffolding.")
}

data class AppState(
    private val mutableNavItems: MutableState<List<NavigationItemDisplayModel>>,
) {
    val navItems: State<List<NavigationItemDisplayModel>> = mutableNavItems

    fun onNavItemSelected(
        stack: AppStack,
    ) {
        mutableNavItems.value = mutableNavItems.value.map { navItem ->
            navItem.copy(
                selected = (navItem.stack == stack),
            )
        }
    }
}

package com.adammcneilly.reader.core.app

import android.os.Parcelable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.adammcneilly.reader.core.displaymodels.NavigationItemDisplayModel
import kotlinx.parcelize.Parcelize

/**
 * A composition local provider for [AppState] allows us to
 * access app wide navigation data from within any subscreen that
 * needs it.
 */
val LocalAppState = staticCompositionLocalOf<AppState> {
    throw IllegalArgumentException("AppState must be provided in the app scaffolding.")
}

/**
 * By extracting the parcelable components out of [AppState], this data
 * class can also be parcelable and persisted across configuration changes
 * using rememberSaveable.
 */
@Parcelize
data class AppStateData(
    val navItems: List<NavigationItemDisplayModel>,
) : Parcelable {
    constructor(
        selectedTab: HomeTab = HomeTab.Home,
    ) : this(
        navItems = HomeTab.entries.map { tab ->
            NavigationItemDisplayModel(
                tab = tab,
                selected = (tab == selectedTab),
            )
        },
    )
}

/**
 * The application state container, it's main purpose to expose the
 * shared business logic like navigation state via [navItems].
 */
class AppState(
    initialData: AppStateData,
) {
    var navItems: List<NavigationItemDisplayModel> by mutableStateOf(initialData.navItems)
        private set

    fun onNavItemSelected(
        tab: HomeTab,
    ) {
        navItems = navItems.map { navItem ->
            navItem.copy(
                selected = (navItem.tab == tab),
            )
        }
    }

    /**
     * Convert this class into something that can actually be saved
     * in rememberSaveable.
     */
    fun toSaveableData(): AppStateData {
        return AppStateData(
            navItems = navItems,
        )
    }
}

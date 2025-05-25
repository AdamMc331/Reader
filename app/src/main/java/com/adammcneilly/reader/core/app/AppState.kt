package com.adammcneilly.reader.core.app

import android.os.Parcelable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.adammcneilly.reader.core.displaymodels.NavigationItemDisplayModel
import kotlinx.parcelize.Parcelize

val LocalAppState = staticCompositionLocalOf<AppState> {
    throw IllegalArgumentException("AppState must be provided in the app scaffolding.")
}

@Parcelize
data class AppStateData(
    val navItems: List<NavigationItemDisplayModel>,
) : Parcelable

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

    fun toSaveableData(): AppStateData {
        return AppStateData(
            navItems = navItems,
        )
    }
}

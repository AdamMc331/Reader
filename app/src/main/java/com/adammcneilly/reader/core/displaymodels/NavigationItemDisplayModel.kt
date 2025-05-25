package com.adammcneilly.reader.core.displaymodels

import android.os.Parcelable
import com.adammcneilly.reader.core.app.HomeTab
import kotlinx.parcelize.Parcelize

/**
 * User friendly representation of a [tab], that
 * includes the [selected] state.
 */
@Parcelize
data class NavigationItemDisplayModel(
    val tab: HomeTab,
    val selected: Boolean,
) : Parcelable

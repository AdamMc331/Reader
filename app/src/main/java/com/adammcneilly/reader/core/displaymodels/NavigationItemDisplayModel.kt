package com.adammcneilly.reader.core.displaymodels

import android.os.Parcelable
import com.adammcneilly.reader.core.app.HomeTab
import kotlinx.parcelize.Parcelize

@Parcelize
data class NavigationItemDisplayModel(
    val tab: HomeTab,
    val selected: Boolean,
) : Parcelable

package com.adammcneilly.reader.core.displaymodels

import com.adammcneilly.reader.core.app.AppStack

data class NavigationItemDisplayModel(
    val stack: AppStack,
    val selected: Boolean,
)

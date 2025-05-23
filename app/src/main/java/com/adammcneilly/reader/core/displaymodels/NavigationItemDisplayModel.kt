package com.adammcneilly.reader.core.displaymodels

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItemDisplayModel(
    val icon: ImageVector,
    val labelRes: Int,
    val selected: Boolean,
)

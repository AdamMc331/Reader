package com.adammcneilly.reader.displaymodels

import androidx.compose.ui.graphics.vector.ImageVector

data class TopBarActionDisplayModel(
    val icon: ImageVector,
    val textResource: Int,
    val onClick: () -> Unit,
)

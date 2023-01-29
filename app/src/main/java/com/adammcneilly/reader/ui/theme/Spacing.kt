package com.adammcneilly.reader.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Spacing(
    val verticalListSpacing: Dp,
)

val LocalSpacing = staticCompositionLocalOf {
    Spacing(
        verticalListSpacing = 0.dp,
    )
}

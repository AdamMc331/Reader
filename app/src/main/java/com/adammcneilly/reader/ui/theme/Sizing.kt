package com.adammcneilly.reader.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines custom sizing properties to be used in a [ReaderTheme] entity.
 */
@Immutable
data class Sizing(
    val verticalListSpacing: Dp,
    val screenPadding: Dp,
    val listItemPadding: Dp,
    val listItemMinWidth: Dp,
    val searchResultImageWidth: Dp,
)

val LocalSizing = staticCompositionLocalOf {
    Sizing(
        verticalListSpacing = 0.dp,
        screenPadding = 0.dp,
        listItemPadding = 0.dp,
        listItemMinWidth = 0.dp,
        searchResultImageWidth = 0.dp,
    )
}

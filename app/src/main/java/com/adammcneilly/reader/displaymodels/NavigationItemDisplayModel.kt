package com.adammcneilly.reader.displaymodels

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * A user friendly representation of a navigation item that appears in either
 * a bottom navigation or a navigation rail.
 *
 * @property[icon] Defines the [ImageVector] for the image associated with this item.
 * @property[labelTextRes] The string resource identifier for the text of this icon, also serves as the
 * icon's content description.
 * @property[selected] If true, this navigation item will show a selected state.
 * @property[onClick] A callback to trigger when the user taps on this navigation item.
 */
data class NavigationItemDisplayModel(
    val icon: ImageVector,
    val labelTextRes: Int,
    val selected: Boolean,
    val onClick: () -> Unit,
)

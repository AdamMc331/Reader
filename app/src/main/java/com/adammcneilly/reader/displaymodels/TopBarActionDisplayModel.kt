package com.adammcneilly.reader.displaymodels

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * A user friendly representation of an action that will appear in a top app bar.
 *
 * @property[icon] The [ImageVector] used to render this display model in an image fashion.
 * @property[textResource] A string resource identifier which is used to either set the content description of
 * this display model, or provide text in a text based situation.
 * @property[onClick] A callback that is triggered whenever the user taps on this app bar icon.
 */
data class TopBarActionDisplayModel(
    val icon: ImageVector,
    val textResource: Int,
    val onClick: () -> Unit,
)

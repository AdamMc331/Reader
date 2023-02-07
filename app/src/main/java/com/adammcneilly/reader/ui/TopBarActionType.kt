package com.adammcneilly.reader.ui

/**
 * Defines the different ways that a top bar action can be displayed to the user.
 *
 * @property[ICON] If selected, actions in the top app bar will appear as icons for the user to tap on.
 * @property[TEXT] If selected, actions in the top app bar will display their full text for the user to tap on them.
 */
enum class TopBarActionType {
    ICON,
    TEXT,
}

package com.adammcneilly.reader.ui

/**
 * This is an enumeration of all of the different ways we can structure navigation in the Reader application.
 *
 * @property[BOTTOM_NAVIGATION] If selected, the application will use a bottom navigation bar on the screen with tabs
 * for the user to select which navigate to a corresponding screen.
 * @property[NAVIGATION_RAIL] If selected, the application will use a side-pinned navigation rail with tabs for the
 * user to select which navigate to a corresponding screen.
 */
enum class ReaderNavigationType {
    BOTTOM_NAVIGATION,
    NAVIGATION_RAIL,
}

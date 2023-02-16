package com.adammcneilly.reader.library

import com.adammcneilly.reader.displaymodels.BookDisplayModel

/**
 * Defines the UI state for the library screen.
 */
data class LibraryViewState(
    val unreadBooks: List<BookDisplayModel> = emptyList(),
    val readBooks: List<BookDisplayModel> = emptyList(),
)

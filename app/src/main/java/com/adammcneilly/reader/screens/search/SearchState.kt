package com.adammcneilly.reader.screens.search

import androidx.compose.ui.text.input.TextFieldValue
import com.adammcneilly.reader.core.displaymodels.BookDisplayModel

data class SearchState(
    val query: TextFieldValue,
    val books: List<BookDisplayModel>,
) {
    companion object {
        fun default(): SearchState =
            SearchState(
                query = TextFieldValue(""),
                books = emptyList(),
            )
    }
}

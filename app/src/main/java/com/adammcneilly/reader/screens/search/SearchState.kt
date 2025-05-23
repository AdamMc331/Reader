package com.adammcneilly.reader.screens.search

import androidx.compose.ui.text.input.TextFieldValue

data class SearchState(
    val query: TextFieldValue,
) {
    companion object {
        fun default(): SearchState =
            SearchState(
                query = TextFieldValue(""),
            )
    }
}

package com.adammcneilly.reader.screens.search

import androidx.compose.ui.text.input.TextFieldValue

sealed interface SearchEvent {
    data class QueryChanged(
        val query: TextFieldValue,
    ) : SearchEvent
}

package com.adammcneilly.reader.screens.search

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.reader.core.displaymodels.BookDisplayModel
import com.adammcneilly.reader.data.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val bookRepository: BookRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(SearchState.default())
    val state = mutableState.asStateFlow()

    init {
        observeQuery()
    }

    private fun observeQuery() {
        val bookQuery = state
            .map { it.query }
            .debounce(timeoutMillis = 300)
            .flatMapConcat { query ->
                bookRepository.searchBooks(query.text)
            }

        viewModelScope.launch {
            bookQuery.collect { books ->
                mutableState.update { currentState ->
                    currentState.copy(
                        books = books.map { book ->
                            BookDisplayModel(book)
                        },
                    )
                }
            }
        }
    }

    fun onQueryChange(
        query: TextFieldValue,
    ) {
        mutableState.update { currentState ->
            currentState.copy(
                query = query,
            )
        }
    }
}

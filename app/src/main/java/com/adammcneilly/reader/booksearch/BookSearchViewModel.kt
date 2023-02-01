package com.adammcneilly.reader.booksearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.reader.data.BookRepository
import com.adammcneilly.reader.data.ExpanseBookRepository
import com.adammcneilly.reader.displaymodels.toDisplayModel
import com.adammcneilly.reader.models.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class BookSearchViewModel(
    private val repository: BookRepository = ExpanseBookRepository()
) : ViewModel() {

    private val _viewState = MutableStateFlow(BookSearchViewState())
    val viewState = _viewState.asStateFlow()

    init {
        _viewState
            .map { it.searchText }
            .debounce(QUERY_DEBOUNCE_MILLIS)
            .onEach { searchText ->
                val books = repository
                    .getBooks(searchText)
                    .map(Book::toDisplayModel)

                _viewState.update {
                    it.copy(results = books)
                }
            }
            .launchIn(viewModelScope)
    }

    fun searchTextChanged(newSearchText: String) {
        _viewState.update {
            it.copy(searchText = newSearchText)
        }
    }

    companion object {
        /**
         * To avoid running a query immediately as we type, we'll debounce
         * for a certain number of millis and only run queries when typing
         * slows or stops.
         */
        private const val QUERY_DEBOUNCE_MILLIS = 300L
    }
}

package com.adammcneilly.reader.booksearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.reader.data.BookRepository
import com.adammcneilly.reader.data.BookSearchService
import com.adammcneilly.reader.displaymodels.toDisplayModel
import com.adammcneilly.reader.models.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * A state management container for the book search screen.
 *
 * @property[repository] A [BookRepository] data source that is used to request books as we search for them.
 */
@HiltViewModel
class BookSearchViewModel @Inject constructor(
    private val repository: BookSearchService,
) : ViewModel() {

    private val _viewState = MutableStateFlow(BookSearchViewState())
    val viewState = _viewState.asStateFlow()

    init {
        _viewState
            .filter { it.searchText.isNotEmpty() }
            .map { it.searchText }
            .distinctUntilChanged()
            .debounce(QUERY_DEBOUNCE_MILLIS)
            .onEach { searchText ->
                _viewState.update {
                    it.copy(
                        isLoadingBooks = true,
                    )
                }
                val books = repository
                    .searchBooks(searchText)
                    .map(Book::toDisplayModel)

                _viewState.update {
                    it.copy(
                        results = books,
                        isLoadingBooks = false,
                    )
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

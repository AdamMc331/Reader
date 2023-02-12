package com.adammcneilly.reader.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.reader.data.BookRepository
import com.adammcneilly.reader.displaymodels.toDisplayModel
import com.adammcneilly.reader.models.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * State container for the library screen.
 *
 * @property[bookRepository] Used to request all of the books that are
 * a part of the user's library.
 */
@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val bookRepository: BookRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(LibraryViewState())
    val state = _state.asStateFlow()

    init {
        getBooksInLibrary()
    }

    private fun getBooksInLibrary() {
        viewModelScope.launch {
            val books = bookRepository.getAllBooksInLibrary()
            val displayModels = books.map(Book::toDisplayModel)

            _state.update { currentState ->
                currentState.copy(
                    books = displayModels,
                )
            }
        }
    }
}

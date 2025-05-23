package com.adammcneilly.reader.screens.search

import androidx.lifecycle.ViewModel
import com.adammcneilly.reader.data.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
    @Inject
    constructor(
        private val bookRepository: BookRepository,
    ) : ViewModel() {
        private val mutableState = MutableStateFlow(SearchState.default())
        val state = mutableState.asStateFlow()
    }

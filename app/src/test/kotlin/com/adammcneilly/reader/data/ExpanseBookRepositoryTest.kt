package com.adammcneilly.reader.data

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ExpanseBookRepositoryTest {
    private val repository = ExpanseBookRepository()

    @Test
    fun queryWithEmptyText() = runTest {
        val bookList = repository.searchBooks("")

        assertThat(bookList).isEmpty()
    }

    @Test
    fun queryWithTitleText() = runTest {
        val bookList = repository.searchBooks("Leviathan")

        assertThat(bookList).hasSize(2)
    }

    @Test
    fun queryWithAuthorText() = runTest {
        val bookList = repository.searchBooks("James S.A. Corey")

        assertThat(bookList).hasSize(9)
    }
}

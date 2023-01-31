package com.adammcneilly.reader.data

import kotlinx.coroutines.test.runTest
import org.junit.Test
import com.google.common.truth.Truth.assertThat

class ExpanseBookRepositoryTest {
    private val repository = ExpanseBookRepository()

    @Test
    fun queryWithEmptyText() = runTest {
        val bookList = repository.getBooks("")

        assertThat(bookList).isEmpty()
    }

    @Test
    fun queryWithTitleText() = runTest {
        val bookList = repository.getBooks("Leviathan")

        assertThat(bookList).hasSize(2)
    }

    @Test
    fun queryWithAuthorText() = runTest {
        val bookList = repository.getBooks("James S.A. Corey")

        assertThat(bookList).hasSize(9)
    }
}

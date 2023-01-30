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
}

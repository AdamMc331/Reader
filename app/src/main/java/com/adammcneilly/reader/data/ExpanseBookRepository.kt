package com.adammcneilly.reader.data

import com.adammcneilly.reader.models.Book

/**
 * A custom implementation of [BookRepository] that will be used for demo purposes.
 */
class ExpanseBookRepository : BookRepository {
    private val expanseBooks = listOf(
        Book(
            id = "1",
            title = "Leviathan Wakes",
            author = "James S.A. Corey",
        ),
        Book(
            id = "2",
            title = "Caliban's War",
            author = "James S.A. Corey",
        ),
        Book(
            id = "3",
            title = "Abaddon's Gate",
            author = "James S.A. Corey",
        ),
        Book(
            id = "4",
            title = "Cibola Burn",
            author = "James S.A. Corey",
        ),
        Book(
            id = "5",
            title = "Nemesis Games",
            author = "James S.A. Corey",
        ),
        Book(
            id = "6",
            title = "Babylon's Ashes",
            author = "James S.A. Corey",
        ),
        Book(
            id = "7",
            title = "Persepolis Rising",
            author = "James S.A. Corey",
        ),
        Book(
            id = "8",
            title = "Tiamat's Wrath",
            author = "James S.A. Corey",
        ),
        Book(
            id = "9",
            title = "Leviathan Falls",
            author = "James S.A. Corey",
        ),
    )

    override suspend fun searchBooks(searchText: String): List<Book> {
        return if (searchText.isEmpty()) {
            emptyList()
        } else {
            expanseBooks.filter { book ->
                book.title.contains(searchText, true) || book.author.contains(searchText, true)
            }
        }
    }
}

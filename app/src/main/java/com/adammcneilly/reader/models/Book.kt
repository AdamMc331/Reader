package com.adammcneilly.reader.models

/**
 * A domain model defining a book that the user has, or plans to, read.
 *
 * @property[id] A unique identifier specific to this book.
 * @property[title] The main piece of text used to identify a book and it's storyline.
 * @property[author] The name of the person who has written this book.
 * @property[thumbnailURL] A remote image URL for the thumbnail of this book's cover.
 * @property[isInLibrary] If true, this book resides in the user's library.
 * @property[isRead] If true, the user has already completed reading this book.
 */
data class Book(
    val id: String = "",
    val title: String = "",
    val author: String = "",
    val thumbnailURL: String? = null,
    val isInLibrary: Boolean = false,
    val isRead: Boolean = false,
)

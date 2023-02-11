package com.adammcneilly.reader.di

import com.adammcneilly.reader.data.BookRepository
import com.adammcneilly.reader.data.BookSearchService
import com.adammcneilly.reader.data.ExpanseBookRepository
import com.adammcneilly.reader.data.googlebooks.GoogleBooksBookSearchService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * This is a dagger [Module] to define all of the repository
 * instances used in the Reader app.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindBookRepository(
        bookRepository: ExpanseBookRepository,
    ): BookRepository

    @Binds
    abstract fun bindBookSearchService(
        bookSearchService: GoogleBooksBookSearchService,
    ): BookSearchService
}

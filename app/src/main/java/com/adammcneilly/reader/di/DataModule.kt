package com.adammcneilly.reader.di

import com.adammcneilly.reader.data.BookRepository
import com.adammcneilly.reader.data.openlibrary.OpenLibraryBookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideBookRepository(
        openLibraryBookRepository: OpenLibraryBookRepository,
    ): BookRepository {
        return openLibraryBookRepository
    }
}

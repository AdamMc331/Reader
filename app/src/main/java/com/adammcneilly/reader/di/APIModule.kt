package com.adammcneilly.reader.di

import com.adammcneilly.reader.data.googlebooks.GoogleBooksAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * A hilt [Module] that defines any various remote APIs that are used in the Reader app.
 */
@Module
@InstallIn(SingletonComponent::class)
object APIModule {

    @Provides
    fun provideGoogleBooksAPI(): GoogleBooksAPI {
        return GoogleBooksAPI.defaultInstance()
    }
}

package com.adammcneilly.reader.di

import com.adammcneilly.reader.data.googlebooks.GoogleBooksAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object APIModule {

    @Provides
    fun provideGoogleBooksAPI(): GoogleBooksAPI {
        return GoogleBooksAPI.defaultInstance()
    }
}

package com.adammcneilly.reader.di

import com.adammcneilly.reader.data.BookRepository
import com.adammcneilly.reader.data.openlibrary.OpenLibraryBookRepository
import com.adammcneilly.reader.data.openlibrary.OpenLibraryRetrofitAPI
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    private const val OPEN_LIBRARY_BASE_URL = "https://openlibrary.org/"

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    @Named("OpenLibraryRetrofit")
    fun provideOpenLibraryRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(OPEN_LIBRARY_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .build()

    @Provides
    @Singleton
    fun provideOpenLibraryApiService(
        retrofit: Retrofit,
    ): OpenLibraryRetrofitAPI = retrofit.create(OpenLibraryRetrofitAPI::class.java)

    @Provides
    @Singleton
    fun provideBookRepository(
        openLibraryBookRepository: OpenLibraryBookRepository,
    ): BookRepository = openLibraryBookRepository
}

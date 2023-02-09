package com.adammcneilly.reader.data.googlebooks

import com.adammcneilly.reader.data.googlebooks.models.GoogleBooksListResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * A retrofit implementation of a network API to talk to Google Books.
 */
interface GoogleBooksAPI {

    @GET("/books/v1/volumes/")
    suspend fun search(
        @Query("q") searchText: String,
    ): GoogleBooksListResponse

    companion object {
        private const val BASE_URL = "https://www.googleapis.com/"

        fun defaultInstance(): GoogleBooksAPI {
            val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()

            val converterFactory = MoshiConverterFactory.create(moshi)

            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            return Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build()
                .create(GoogleBooksAPI::class.java)
        }
    }
}

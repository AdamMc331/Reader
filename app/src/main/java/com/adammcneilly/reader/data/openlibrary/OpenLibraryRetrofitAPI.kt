package com.adammcneilly.reader.data.openlibrary

import com.adammcneilly.reader.data.openlibrary.dto.OpenLibraryBookResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryRetrofitAPI {
    @GET("search.json")
    suspend fun searchBooks(
        @Query("q") query: String,
    ): OpenLibraryBookResponseDTO
}

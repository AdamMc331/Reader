package com.adammcneilly.reader.data.openlibrary.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OpenLibraryBookResponseDTO(
    @Json(name = "docs")
    val docs: List<OpenLibraryBookDTO?>? = null,
    @Json(name = "documentation_url")
    val documentationUrl: String? = null,
    @Json(name = "numFound")
    val numFound: Int? = null,
    @Json(name = "numFoundExact")
    val numFoundExact: Boolean? = null,
    @Json(name = "q")
    val q: String? = null,
    @Json(name = "start")
    val start: Int? = null,
)

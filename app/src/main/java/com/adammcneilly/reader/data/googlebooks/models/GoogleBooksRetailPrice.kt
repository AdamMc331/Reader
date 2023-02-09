package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksRetailPrice(
    @Json(name = "amountInMicros")
    val amountInMicros: Int? = null,
    @Json(name = "currencyCode")
    val currencyCode: String? = null,
)

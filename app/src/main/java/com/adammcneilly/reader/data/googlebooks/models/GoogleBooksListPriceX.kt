package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksListPriceX(
    @Json(name = "amountInMicros")
    val amountInMicros: Int? = null,
    @Json(name = "currencyCode")
    val currencyCode: String? = null,
)

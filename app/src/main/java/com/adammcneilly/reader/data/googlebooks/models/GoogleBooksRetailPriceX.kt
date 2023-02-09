package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksRetailPriceX(
    @Json(name = "amount")
    val amount: Double? = null,
    @Json(name = "currencyCode")
    val currencyCode: String? = null,
)

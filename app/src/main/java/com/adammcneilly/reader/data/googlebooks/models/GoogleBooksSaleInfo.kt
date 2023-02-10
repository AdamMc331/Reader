package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksSaleInfo(
    @Json(name = "buyLink")
    val buyLink: String? = "",
    @Json(name = "country")
    val country: String? = "",
    @Json(name = "isEbook")
    val isEbook: Boolean? = false,
    @Json(name = "listPrice")
    val listPrice: GoogleBooksListPrice? = GoogleBooksListPrice(),
    @Json(name = "offers")
    val offers: List<GoogleBooksOffer>? = listOf(),
    @Json(name = "retailPrice")
    val retailPrice: GoogleBooksRetailPriceX? = GoogleBooksRetailPriceX(),
    @Json(name = "saleability")
    val saleability: String? = "",
)

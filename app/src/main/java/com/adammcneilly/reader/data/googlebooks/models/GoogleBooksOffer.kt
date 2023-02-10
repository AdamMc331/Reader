package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksOffer(
    @Json(name = "finskyOfferType")
    val finskyOfferType: Int? = 0,
    @Json(name = "giftable")
    val giftable: Boolean? = false,
    @Json(name = "listPrice")
    val listPrice: GoogleBooksListPriceX? = GoogleBooksListPriceX(),
    @Json(name = "retailPrice")
    val retailPrice: GoogleBooksRetailPrice? = GoogleBooksRetailPrice(),
)

package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksVolumeInfo(
    @Json(name = "allowAnonLogging")
    val allowAnonLogging: Boolean? = null,
    @Json(name = "authors")
    val authors: List<String?>? = null,
    @Json(name = "averageRating")
    val averageRating: Double? = null,
    @Json(name = "canonicalVolumeLink")
    val canonicalVolumeLink: String? = null,
    @Json(name = "categories")
    val categories: List<String?>? = null,
    @Json(name = "contentVersion")
    val contentVersion: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "imageLinks")
    val imageLinks: GoogleBooksImageLinks? = null,
    @Json(name = "industryIdentifiers")
    val industryIdentifiers: List<GoogleBooksIndustryIdentifier?>? = null,
    @Json(name = "infoLink")
    val infoLink: String? = null,
    @Json(name = "language")
    val language: String? = null,
    @Json(name = "maturityRating")
    val maturityRating: String? = null,
    @Json(name = "pageCount")
    val pageCount: Int? = null,
    @Json(name = "panelizationSummary")
    val panelizationSummary: GoogleBooksPanelizationSummary? = null,
    @Json(name = "previewLink")
    val previewLink: String? = null,
    @Json(name = "printType")
    val printType: String? = null,
    @Json(name = "publishedDate")
    val publishedDate: String? = null,
    @Json(name = "publisher")
    val publisher: String? = null,
    @Json(name = "ratingsCount")
    val ratingsCount: Int? = null,
    @Json(name = "readingModes")
    val readingModes: GoogleBooksReadingModes? = null,
    @Json(name = "subtitle")
    val subtitle: String? = null,
    @Json(name = "title")
    val title: String? = null,
)

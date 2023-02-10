package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksPanelizationSummary(
    @Json(name = "containsEpubBubbles")
    val containsEpubBubbles: Boolean? = null,
    @Json(name = "containsImageBubbles")
    val containsImageBubbles: Boolean? = null,
)

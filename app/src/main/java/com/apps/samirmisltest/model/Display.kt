package com.apps.samirmisltest.model

import com.squareup.moshi.Json

data class Display(
    @Json(name = "Aspect Ratio")
    val aspectRatio: String?,
    @Json(name = "Display Type")
    val displayType: String?,
    val Resolution: String?,
    @Json(name = "Screen Size")
    val screenSize: String?
)

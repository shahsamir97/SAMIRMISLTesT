package com.apps.therapassignment.model

import com.squareup.moshi.Json

data class OS(
    @Json(name = "Operating System")
    val operatingSystem: String?
)
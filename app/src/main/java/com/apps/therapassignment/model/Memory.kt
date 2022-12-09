package com.apps.therapassignment.model

import com.squareup.moshi.Json

data class Memory(
    @Json(name = "RAM Size (GB)")
    val ram: String?,
    @Json(name = "ROM Size (GB)")
    val rom: String?
)

package com.apps.samirmisltest.model

import com.squareup.moshi.Json

data class Audio(
    @Json(name = "Dolby Digital Plus")
    val dolbyDigitalPlus: String?,
    @Json(name = "Sound Output (RMS)")
    val soundOutput: String?,
    @Json(name = "Speaker Type")
    val speakerType: String?
)

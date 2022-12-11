package com.apps.samirmisltest.model

import com.squareup.moshi.Json

data class Connectivity(
    val HDMI: String?,
    val USB: String?,
    @Json(name = "Wi-Fi")
    val wifi: String?,
    @Json(name = "WiFi Direct")
    val wifiDirect: String?
)

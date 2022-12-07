package com.apps.therapassignment.model

import com.squareup.moshi.Json

data class Video(
    @Json(name = "Auto Motion Plus")
    val AutoMotionPlus: String,
    val Color: String,
    val Contrast: String,
    @Json(name = "Contrast Enhancer")
    val ContrastEnhancer: String,
    @Json(name = "HDR (High Dynamic Range)")
    val hdr: String,
    @Json(name = "HDR 10+")
    val hdr10plus: String,
    @Json(name = "One Billion Color")
    val oneBillionColor: String,
    @Json(name = "PQI (Picture Quality Index)")
    val pictureQualityIndex: String,
    @Json(name = "Picture Engine")
    val pictureEngine: String,
    @Json(name = "Refresh Rate")
    val refreshRate: String
)
package com.apps.samirmisltest.model

import com.squareup.moshi.Json

data class DimensionsMm(
    @Json(name = "Set Size with Stand (WxHxD)")
    val setSizeWithStand: String?,
    @Json(name = "Set Size without Stand (WxHxD)")
    val setSizeWithoutStand: String?
)

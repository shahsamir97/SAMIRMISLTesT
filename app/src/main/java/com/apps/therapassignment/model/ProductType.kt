package com.apps.therapassignment.model

import com.squareup.moshi.Json

data class ProductType(
    @Json(name = "Product Type")
    val productType: String?
)
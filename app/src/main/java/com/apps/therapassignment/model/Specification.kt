package com.apps.therapassignment.model

import com.squareup.moshi.Json

data class Specification(
    val Audio: Audio?,
    val Connectivity: Connectivity?,
    @Json(name = "Dimensions (mm)")
    val dimensions: DimensionsMm?,
    val Display: Display?,
    val Memory: Memory?,
    val OS: OS?,
    val Processor: Processor?,
    @Json(name = "Product Type")
    val productType: ProductType?,
    val Video: Video?
)
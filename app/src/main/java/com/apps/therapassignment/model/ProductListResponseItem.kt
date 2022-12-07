package com.apps.therapassignment.model

data class ProductListResponseItem(
    val description: String,
    val id: Int,
    val image_url: String,
    val model: String,
    val name: String,
    val price: Int,
    val size: Int,
    val specification: Specification,
    val title: String
)
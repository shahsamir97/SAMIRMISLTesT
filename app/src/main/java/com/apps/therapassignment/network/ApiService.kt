package com.apps.therapassignment.network

import com.apps.therapassignment.model.ProductListResponseItem
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductListResponseItem>
}
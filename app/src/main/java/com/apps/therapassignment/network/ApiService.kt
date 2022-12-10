package com.apps.therapassignment.network

import com.apps.therapassignment.model.ProductDetailsRequestBody
import com.apps.therapassignment.model.ProductDetailsResponse
import com.apps.therapassignment.model.ProductListResponseItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface  ApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductListResponseItem>

    @POST("products/by_id")
    suspend fun getProductDetails(@Body productDetailsRequestBody: ProductDetailsRequestBody): ProductDetailsResponse
}

package com.apps.samirmisltest.network

import com.apps.samirmisltest.model.ProductDetailsRequestBody
import com.apps.samirmisltest.model.ProductDetailsResponse
import com.apps.samirmisltest.model.ProductListResponseItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface  ApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductListResponseItem>

    @POST("products/by_id")
    suspend fun getProductDetails(@Body productDetailsRequestBody: ProductDetailsRequestBody): ProductDetailsResponse
}

package com.apps.therapassignment.network

import com.apps.therapassignment.model.ProductListResponseItem
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("products")
    suspend fun getProducts(@Header("Secret_Code") header: String = "e92d1aa5f67ce24713cf638550f5daa84ef5ea3466ae29af8b1ad16fbe6c5fbb"): List<ProductListResponseItem>
}
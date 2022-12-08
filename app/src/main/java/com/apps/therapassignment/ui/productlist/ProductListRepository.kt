package com.apps.therapassignment.ui.productlist

import com.apps.therapassignment.network.ApiService

class ProductListRepository(private val apiService: ApiService) {

    suspend fun getAllProducts() = apiService.getProducts()
}
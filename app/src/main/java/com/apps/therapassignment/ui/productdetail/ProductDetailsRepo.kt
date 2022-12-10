package com.apps.therapassignment.ui.productdetail

import com.apps.therapassignment.model.ProductDetailsRequestBody
import com.apps.therapassignment.network.ApiService

class ProductDetailsRepo(private val apiService: ApiService) {

    suspend fun getProductDetails(productId: Int) =
        apiService.getProductDetails(ProductDetailsRequestBody(id = productId))
}

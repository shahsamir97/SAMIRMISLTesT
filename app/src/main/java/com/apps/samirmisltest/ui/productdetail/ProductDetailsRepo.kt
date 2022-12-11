package com.apps.samirmisltest.ui.productdetail

import com.apps.samirmisltest.model.ProductDetailsRequestBody
import com.apps.samirmisltest.network.ApiService

class ProductDetailsRepo(private val apiService: ApiService) {

    suspend fun getProductDetails(productId: Int) =
        apiService.getProductDetails(ProductDetailsRequestBody(id = productId))
}

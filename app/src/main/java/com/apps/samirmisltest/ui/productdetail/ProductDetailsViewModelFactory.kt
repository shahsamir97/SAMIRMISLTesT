package com.apps.samirmisltest.ui.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductDetailsViewModelFactory(private val productId: Int, private val repo: ProductDetailsRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductDetailsViewModel::class.java))
            return ProductDetailsViewModel(productId, repo) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

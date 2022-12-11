package com.apps.samirmisltest.ui.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductListViewModelFactory(private val repo: ProductListRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java))
            return ProductListViewModel(repo) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
package com.apps.therapassignment.ui.productlist

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apps.therapassignment.database.ProductDao
import com.apps.therapassignment.database.ProductDatabaseModel
import com.apps.therapassignment.model.ProductListResponseItem
import com.apps.therapassignment.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductListRepository(
    private val apiService: ApiService,
    private val productDao: ProductDao
) {

    private val _productList = MutableLiveData<List<ProductDatabaseModel>>()
    val productList: LiveData<List<ProductDatabaseModel>>
        get() = _productList


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(productList: List<ProductDatabaseModel>) {
        productDao.insertAll(productList)
    }

    suspend fun getAllProducts(): List<ProductListResponseItem> {
        val list = apiService.getProducts()
        withContext(Dispatchers.IO){
            insert(list.map { product ->
                ProductDatabaseModel(
                    uid = product.id,
                    productName = product.name ?: "N/A",
                    productPrice = product.price,
                    description = product.description ?: "N/A",
                    imageUrl = product.image_url ?: ""
                )
            })
        }
        return list

    }
}
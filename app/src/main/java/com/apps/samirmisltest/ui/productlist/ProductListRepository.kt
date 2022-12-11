package com.apps.samirmisltest.ui.productlist

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.apps.samirmisltest.database.ProductDao
import com.apps.samirmisltest.database.ProductDatabaseModel
import com.apps.samirmisltest.network.ApiService
import com.apps.samirmisltest.ui.productlist.ProductListPagingSource.Companion.INITIAL_LOAD_SIZE
import com.apps.samirmisltest.ui.productlist.ProductListPagingSource.Companion.PAGE_SIZE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ProductListRepository(
    private val apiService: ApiService,
    private val productDao: ProductDao
) {

    suspend fun getAllProducts() {
        val list = apiService.getProducts()
        withContext(Dispatchers.IO){
            productDao.insertAll(list.map { product ->
                ProductDatabaseModel(
                    uid = product.id,
                    productName = product.name ?: "N/A",
                    productPrice = product.price,
                    description = product.description ?: "N/A",
                    imageUrl = product.image_url ?: ""
                )
            })
        }
    }

    fun getProductPagedData(): Flow<PagingData<ProductDatabaseModel>> {
        return Pager(config = PagingConfig(
            pageSize = PAGE_SIZE,
            initialLoadSize = INITIAL_LOAD_SIZE,
            enablePlaceholders = false,
        ),
            pagingSourceFactory = { ProductListPagingSource(productDao)}
        ).flow
    }
}

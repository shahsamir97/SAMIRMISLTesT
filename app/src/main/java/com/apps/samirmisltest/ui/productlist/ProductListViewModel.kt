package com.apps.samirmisltest.ui.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.apps.samirmisltest.database.ProductDatabaseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProductListViewModel(private val repo: ProductListRepository): ViewModel() {

    val pagedListHoliday: Flow<PagingData<ProductDatabaseModel>> =
        repo.getProductPagedData().cachedIn(viewModelScope)

    private val _showMessage = MutableLiveData<String>()
    val showMessage : LiveData<String>
    get() = _showMessage

    init {
        fetchProducts()
    }

    private fun fetchProducts(){
        viewModelScope.launch {
            try {
                repo.getAllProducts()
            }catch (e: java.lang.Exception){
                e.printStackTrace()
                _showMessage.value = "Something went wrong! Please Check your internet connection"
            }
        }
    }
}

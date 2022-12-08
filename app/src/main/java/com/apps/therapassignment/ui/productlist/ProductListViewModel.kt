package com.apps.therapassignment.ui.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.therapassignment.model.ProductListResponseItem
import kotlinx.coroutines.launch

class ProductListViewModel(private val repo: ProductListRepository): ViewModel() {

    private val _productList = MutableLiveData<ArrayList<ProductListResponseItem>>()
    val productList : LiveData<ArrayList<ProductListResponseItem>>
    get() = _productList

    private val _showMessage = MutableLiveData<String>()
    val showMessage : LiveData<String>
    get() = _showMessage

    init {
        fetchProducts()
    }

    private fun fetchProducts(){
        viewModelScope.launch {
            try {
                val response = repo.getAllProducts()
                _productList.value =  response as ArrayList<ProductListResponseItem>
            }catch (e: java.lang.Exception){
                e.printStackTrace()
                _showMessage.value = "Something went wrong! Please Check your internet connection"
            }
        }
    }
}
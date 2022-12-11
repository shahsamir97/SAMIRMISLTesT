package com.apps.samirmisltest.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.samirmisltest.model.ProductDetailsResponse
import kotlinx.coroutines.launch

class ProductDetailsViewModel(private val productId:Int, private val repo: ProductDetailsRepo): ViewModel() {

    private val _productDetails = MutableLiveData<ProductDetailsResponse>()
    val productDetails: LiveData<ProductDetailsResponse>
    get() = _productDetails

    private val _showMessage = MutableLiveData<String>()
    val showMessage: LiveData<String>
    get() = _showMessage

    init {
        fetchProductDetails()
    }

    private fun fetchProductDetails(){
        viewModelScope.launch {
            try {
                val productDetailsResponse = repo.getProductDetails(productId)
                _productDetails.value = productDetailsResponse
            }catch (e: Exception){
                e.printStackTrace()
                _showMessage.value = "Something went wrong!Check internet connection"
            }
        }
    }
}

package com.apps.therapassignment.ui.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductListViewModel(private val repo: ProductListRepository): ViewModel() {

    init {
        fetchFacebookRepos()
    }

    private fun fetchFacebookRepos(){
        viewModelScope.launch {
            repo.getFacebookRepos()
        }
    }
}
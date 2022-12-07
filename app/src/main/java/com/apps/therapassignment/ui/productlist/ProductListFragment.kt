package com.apps.therapassignment.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.apps.therapassignment.R
import com.apps.therapassignment.network.ServiceGenerator

class ProductListFragment : Fragment() {

    lateinit var adapter: ProductListAdapter
    private val viewModel: ProductListViewModel by viewModels {
        ProductListViewModelFactory(ProductListRepository(ServiceGenerator.apiService))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun initUi() {

    }

}
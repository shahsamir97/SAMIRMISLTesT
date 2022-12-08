package com.apps.therapassignment.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.apps.therapassignment.GloryTvApplication
import com.apps.therapassignment.databinding.FragmentProductListBinding
import com.apps.therapassignment.network.ServiceGenerator

class ProductListFragment : Fragment() {

    lateinit var adapter: ProductListAdapter
    lateinit var binding : FragmentProductListBinding

    private val viewModel: ProductListViewModel by viewModels {
        ProductListViewModelFactory(ProductListRepository(ServiceGenerator.apiService,
            (requireActivity().applicationContext as GloryTvApplication).db.ProductDao()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        setUpObservers()
    }

    private fun initUi() {
        adapter = ProductListAdapter(ArrayList())
        binding.productList.adapter = adapter
    }

    private fun setUpObservers(){
        viewModel.productList.observe(viewLifecycleOwner){
            adapter.updateData(it)
        }

        viewModel.showMessage.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }
}
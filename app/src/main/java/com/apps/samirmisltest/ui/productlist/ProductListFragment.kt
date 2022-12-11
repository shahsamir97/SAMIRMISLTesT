package com.apps.samirmisltest.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.apps.samirmisltest.GloryTvApplication
import com.apps.samirmisltest.R
import com.apps.samirmisltest.databinding.FragmentProductListBinding
import com.apps.samirmisltest.network.ServiceGenerator
import kotlinx.coroutines.flow.collectLatest

class ProductListFragment : Fragment() {

    private lateinit var adapter: ProductListAdapter
    private lateinit var binding : FragmentProductListBinding

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
        adapter = ProductListAdapter{
            findNavController().navigate(R.id.action_repoListFragment_to_addNoteFragment, bundleOf("productId" to it))
        }
        binding.productList.adapter = adapter
    }

    private fun setUpObservers(){
        viewModel.showMessage.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.pagedListHoliday.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}

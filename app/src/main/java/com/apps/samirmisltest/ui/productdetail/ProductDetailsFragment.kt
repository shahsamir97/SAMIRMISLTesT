package com.apps.samirmisltest.ui.productdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.apps.samirmisltest.network.ServiceGenerator
import com.apps.therapassignment.R
import com.apps.therapassignment.databinding.FragmentProductDetailsBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private val viewModel: ProductDetailsViewModel by viewModels {
        val productId = requireArguments().getInt("productId")
        ProductDetailsViewModelFactory(productId,ProductDetailsRepo(ServiceGenerator.apiService))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showMessage.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.productDetails.observe(viewLifecycleOwner){
            with(binding){
                productTitle.text = it.title
                productPrice.text = getString(R.string.product_price, it.price.toString())
                screenSize.text = getString(R.string.screen_size, it.specification.Display?.screenSize)
                aspectRatio.text = getString(R.string.aspect_ratio, it.specification.Display?.aspectRatio)
                ramAndRom.text = getString(R.string.ram_rom, it.specification.Memory?.ram, it.specification.Memory?.rom)
                Glide.with(requireContext()).load(it.image_url).apply(
                    RequestOptions()
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .error(R.drawable.ic_baseline_broken_image_24)).into(productImageView)
            }
        }
    }
}

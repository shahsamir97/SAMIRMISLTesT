package com.apps.therapassignment.ui.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.therapassignment.databinding.ItemProductLayoutBinding
import com.apps.therapassignment.model.ProductListResponseItem
import com.bumptech.glide.Glide

class ProductListAdapter(private var productList: ArrayList<ProductListResponseItem>) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemProductLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemProductLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding){
            (productList[position]).let { product ->
                productName.text = product.name
                productCategory.text = product.specification?.productType?.productType
                productDescription.text = product.description
                Glide.with(productImage.context).load(product.image_url).into(productImage)
            }
        }
    }

    override fun getItemCount(): Int = productList.size

    fun updateData(data: ArrayList<ProductListResponseItem>){
        productList.clear()
        productList = data
    }
}
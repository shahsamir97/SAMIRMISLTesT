package com.apps.therapassignment.ui.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.apps.therapassignment.R
import com.apps.therapassignment.database.ProductDatabaseModel
import com.apps.therapassignment.databinding.ItemProductLayoutBinding
import com.bumptech.glide.Glide

class ProductListAdapter:PagingDataAdapter<ProductDatabaseModel, ProductListAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProductDatabaseModel>() {
            override fun areItemsTheSame(oldItem: ProductDatabaseModel, newItem: ProductDatabaseModel): Boolean =
                oldItem.uid == newItem.uid

            override fun areContentsTheSame(oldItem: ProductDatabaseModel, newItem: ProductDatabaseModel): Boolean =
                oldItem == newItem
        }
    }

    inner class ViewHolder(val binding: ItemProductLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemProductLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding){
            (getItem(position).let { product ->
                productName.text = product?.productName
                productPrice.text = holder.binding.productPrice.context.getString(R.string.product_price, product?.productPrice.toString())
                productDescription.text = product?.description
                Glide.with(productImage.context).load(product?.imageUrl).into(productImage)
            })
        }
    }
}

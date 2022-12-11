package com.apps.samirmisltest.ui.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.apps.samirmisltest.R
import com.apps.samirmisltest.database.ProductDatabaseModel
import com.apps.samirmisltest.databinding.ItemProductLayoutBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProductListAdapter(private val onClickItem:(productId:Int)-> Unit):
    PagingDataAdapter<ProductDatabaseModel, ProductListAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProductDatabaseModel>() {
            override fun areItemsTheSame(
                oldItem: ProductDatabaseModel,
                newItem: ProductDatabaseModel
            ): Boolean =
                oldItem.uid == newItem.uid

            override fun areContentsTheSame(
                oldItem: ProductDatabaseModel,
                newItem: ProductDatabaseModel
            ): Boolean =
                oldItem == newItem
        }
    }

    inner class ViewHolder(val binding: ItemProductLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemProductLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            (getItem(position).let { product ->
                productName.text = product?.productName
                productPrice.text = holder.binding.productPrice.context.getString(
                    R.string.product_price,
                    product?.productPrice.toString()
                )
                productDescription.text = product?.description

                Glide.with(productImage.context).load(product?.imageUrl).apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_baseline_image_24)
                        .error(R.drawable.ic_baseline_broken_image_24)).into(productImage)

                root.setOnClickListener { onClickItem(product!!.uid) }
            })
        }
    }
}

package com.example.product_viewer.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.data.repo.roomDB.entity.ProductEntity
import com.example.product_viewer.databinding.CardProductBinding


class HomeAdapter(private val products: MutableList<ProductEntity>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: CardProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductEntity) {

            binding.product = product

            binding.root.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(product.id)
                binding.root.findNavController().navigate(action)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    fun updateList(products: List<ProductEntity>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

}
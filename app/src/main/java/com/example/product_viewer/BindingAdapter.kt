package com.example.product_viewer

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.repo.roomDB.entity.ProductEntity
import com.example.product_viewer.home.HomeAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val url = "$imgUrl"

        Glide.with(imgView.rootView.context)
            .load(url)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .centerCrop()
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<ProductEntity>?
) {
    val adapter = recyclerView.adapter as HomeAdapter
    data?.let { adapter.updateList(it) }

}
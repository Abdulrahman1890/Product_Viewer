package com.example.data.repo.roomDB.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.Product
import com.example.domain.entity.ProductX

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val id: Int,
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String

)

fun List<ProductEntity>.asJsonModel(): List<ProductX> {
    return map {
        ProductX(
            id = it.id,
            brand = it.brand,
            category = it.category,
            description = it.description,
            discountPercentage = it.discountPercentage,
            price = it.price,
            rating = it.rating,
            stock = it.stock,
            thumbnail = it.thumbnail,
            title = it.title,
        )
    }
}

fun List<ProductX>.asDatabaseModel(): List<ProductEntity> {
    return map {
        ProductEntity(
            id = it.id,
            brand = it.brand,
            category = it.category,
            description = it.description,
            discountPercentage = it.discountPercentage,
            price = it.price,
            rating = it.rating,
            stock = it.stock,
            thumbnail = it.thumbnail,
            title = it.title,
        )
    }
}
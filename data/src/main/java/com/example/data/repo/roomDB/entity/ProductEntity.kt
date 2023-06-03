package com.example.data.repo.roomDB.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.Product

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val id: String,
    val description: String,
    val image_url: String,
    val name: String,
    val price: String

)

fun List<ProductEntity>.asJsonModel(): List<Product> {
    return map {
        Product(
            id = it.id,
            description = it.description,
            image_url = it.image_url,
            name = it.name,
            price = it.price
        )
    }
}

fun List<Product>.asDatabaseModel(): List<ProductEntity> {
    return map {
        ProductEntity(
            id = it.id,
            description = it.description.orEmpty(),
            image_url = it.image_url,
            name = it.name,
            price = it.price
        )
    }
}
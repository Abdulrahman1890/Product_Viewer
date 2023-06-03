package com.example.domain.entity

data class ProductResponseItem(
    val Product: Product,
    val ProductMerchants: List<ProductMerchant>
)
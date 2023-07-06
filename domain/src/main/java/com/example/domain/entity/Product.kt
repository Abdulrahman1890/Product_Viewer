package com.example.domain.entity

data class Product(
    val limit: Int,
    val products: List<ProductX>,
    val skip: Int,
    val total: Int
)
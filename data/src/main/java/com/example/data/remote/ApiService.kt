package com.example.data.remote

import com.example.domain.entity.ProductResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET("featured.txt")
    suspend fun getProducts(): List<ProductResponseItem>
}
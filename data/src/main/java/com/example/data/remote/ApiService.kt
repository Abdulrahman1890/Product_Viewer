package com.example.data.remote

import com.example.domain.entity.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): Product
}
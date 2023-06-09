package com.example.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.data.remote.Api
import com.example.data.repo.roomDB.ProductDataBase
import com.example.data.repo.roomDB.entity.ProductEntity
import com.example.data.repo.roomDB.entity.asDatabaseModel
import com.example.domain.entity.ProductX
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepoImpl(private val database: ProductDataBase) {

    suspend fun refreshProducts() {
        try {
            withContext(Dispatchers.IO) {
                val productResponse = Api.retrofitService.getProducts()
                database.productDao.addProduct(productResponse.products.asDatabaseModel())
            }
        } catch (e: Exception) {
            Log.e("Internet", "Please open the Internet")
        }


    }

     val product = database.productDao.getProducts()


}
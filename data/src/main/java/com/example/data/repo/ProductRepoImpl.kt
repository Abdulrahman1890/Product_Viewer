package com.example.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.data.remote.Api
import com.example.data.repo.roomDB.ProductDataBase
import com.example.data.repo.roomDB.entity.ProductEntity
import com.example.data.repo.roomDB.entity.asDatabaseModel
import com.example.domain.entity.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepoImpl(private val database: ProductDataBase) {

    suspend fun refreshProducts() {
        try {
            withContext(Dispatchers.IO) {
                val productResponse = Api.retrofitService.getProducts()
                val productlist = mutableListOf<Product>()
                for (productResponseItem in productResponse) {
                    productlist.add(productResponseItem.Product)
                }
                database.productDao.addProduct(productlist.asDatabaseModel())
            }
        } catch (e: Exception) {
            Log.e("Internet", "Please open the Internet")
        }


    }

    val product: LiveData<List<ProductEntity>> = database.productDao.getProducts()

}
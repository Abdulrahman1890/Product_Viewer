package com.example.data.repo.roomDB

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.data.repo.roomDB.entity.ProductEntity

@Dao
interface Dao {

    //getAllProducts
    @Query("SELECT * FROM products")
    fun getProducts(): LiveData<List<ProductEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProduct(products: List<ProductEntity>)

}
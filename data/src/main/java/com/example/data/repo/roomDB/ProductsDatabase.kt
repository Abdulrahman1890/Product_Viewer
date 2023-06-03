package com.example.data.repo.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.repo.roomDB.entity.ProductEntity


@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDataBase : RoomDatabase() {
    abstract val productDao: Dao

    companion object {
        @Volatile
        private var INSTANCE: ProductDataBase? = null

        fun getInstance(context: Context): ProductDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDataBase::class.java,
                    "ProductView"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                instance
            }
        }
    }
}
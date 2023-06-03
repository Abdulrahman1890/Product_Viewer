package com.example.product_viewer.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.data.repo.roomDB.ProductDataBase
import com.example.data.repo.roomDB.entity.ProductEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val database = ProductDataBase.getInstance(application.applicationContext)
    private val productLiveData = MutableLiveData<ProductEntity>()
    val product: LiveData<ProductEntity> = productLiveData

    fun getDetails(productId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                productLiveData.postValue(database.productDao.getProductInfo(productId).get(0))
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

}
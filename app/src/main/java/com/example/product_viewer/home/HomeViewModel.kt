package com.example.product_viewer.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repo.RepoImpl
import com.example.data.repo.roomDB.ProductDataBase
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val database = ProductDataBase.getInstance(application.applicationContext)
    private val repo = RepoImpl(database)

    init {
        viewModelScope.launch {
            repo.refreshProducts()
        }
    }

    val product = repo.product
}
package com.example.proyectoandroidcrafters.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoandroidcrafters.core.ProductRepository
import com.example.proyectoandroidcrafters.model.ProductData
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val productRepository = ProductRepository()
    private val _productInfo = MutableLiveData<List<ProductData>>()
    val productInfo: LiveData<ProductData>
        get() = _productInfo
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState

    fun fetchProductInfo(): List<ProductData>{
        _loaderState.value = true
        viewModelScope.launch {
            val response = productRepository.fetchProductInfo()
            _loaderState.value = false
            response?.let {  product ->
        } ?:run{

            }
    }

}
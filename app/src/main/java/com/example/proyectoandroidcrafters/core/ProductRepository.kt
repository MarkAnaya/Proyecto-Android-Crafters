package com.example.proyectoandroidcrafters.core

import android.util.Log
import com.example.proyectoandroidcrafters.model.ProductData

class ProductRepository {
    private val retrofit = RetrofitInstance.getRetrofit().create(ProductAPI::class.java)

    suspend fun fetchProductInfo(): List<ProductData>? {
    val response = retrofit.getProductInfo()
        return response.body()
    }
}
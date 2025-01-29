package com.example.proyectoandroidcrafters.core

import com.example.proyectoandroidcrafters.model.ProductData
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {
    @GET("products")
    suspend fun getProductInfo(): Response<List<ProductData>>

}
package com.example.proyectoandroidcrafters.model

data class ProductData (
    val title: String,
    val price: Int,
    val description: String,
    val image : String,
    val rate: Rate
)

data class Rate(
    val rate: Int,
    val count: Int
)
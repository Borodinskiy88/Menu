package ru.borodinskiy.aleksei.menu.entity

data class FoodItem(
    val country: String,
    val dsc: String,
    val id: String,
    val img: String,
    val name: String,
    val price: Double,
    val rate: Int
)
package ru.borodinskiy.aleksei.menu.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pizzas(
    val country: String,
    val dsc: String,
    @PrimaryKey
    val id: String,
    val img: String,
    val name: String,
    val price: Double,
    val rate: Int
)

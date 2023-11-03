package ru.borodinskiy.aleksei.menu.api

import retrofit2.http.GET
import ru.borodinskiy.aleksei.menu.entity.Burgers
import ru.borodinskiy.aleksei.menu.entity.Drinks
import ru.borodinskiy.aleksei.menu.entity.IceCream
import ru.borodinskiy.aleksei.menu.entity.Pizzas

interface ApiService {

    @GET("burgers")
    suspend fun getBurgers() : List<Burgers>

    @GET("pizzas")
    suspend fun getPizzas() : List<Pizzas>

    @GET("drinks")
    suspend fun getDrinks() : List<Drinks>

    @GET("ice-cream")
    suspend fun getIceCream() : List<IceCream>
}
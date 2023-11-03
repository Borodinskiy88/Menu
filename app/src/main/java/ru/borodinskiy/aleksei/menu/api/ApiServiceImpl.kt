package ru.borodinskiy.aleksei.menu.api

import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiServices: ApiService) {

    suspend fun getBurgers() = apiServices.getBurgers()
    suspend fun getPizzas() = apiServices.getPizzas()
    suspend fun getDrinks() = apiServices.getDrinks()
    suspend fun getIceCream() = apiServices.getIceCream()

}
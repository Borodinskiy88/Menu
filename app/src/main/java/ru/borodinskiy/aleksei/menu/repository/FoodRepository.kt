package ru.borodinskiy.aleksei.menu.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.borodinskiy.aleksei.menu.api.ApiServiceImpl
import ru.borodinskiy.aleksei.menu.dao.FoodDao
import ru.borodinskiy.aleksei.menu.entity.Burgers
import ru.borodinskiy.aleksei.menu.entity.Drinks
import ru.borodinskiy.aleksei.menu.entity.IceCream
import ru.borodinskiy.aleksei.menu.entity.Pizzas
import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val apiServiceImpl: ApiServiceImpl,
    private val foodDao: FoodDao
) {

    val allBurgers = foodDao.getBurger()
    val allPizzas = foodDao.getPizzas()
    val allDrinks = foodDao.getDrinks()
    val allIceCream = foodDao.getIceCream()

    fun getBurgers(): Flow<List<Burgers>> = flow {
        try {
            val response = apiServiceImpl.getBurgers()
            emit(response)
            foodDao.insertBurgers(response)
        } catch (e: Exception) {
            return@flow
        }
    }.flowOn(Dispatchers.IO)

    fun getPizzas(): Flow<List<Pizzas>> = flow {
        try {
            val response = apiServiceImpl.getPizzas()
            emit(response)
            foodDao.insertPizzas(response)
        } catch (e: Exception) {
            return@flow
        }
    }.flowOn(Dispatchers.IO)

    fun getDrinks(): Flow<List<Drinks>> = flow {
        try {
            val response = apiServiceImpl.getDrinks()
            emit(response)
            foodDao.insertDrinks(response)
        } catch (e: Exception) {
            return@flow
        }
    }.flowOn(Dispatchers.IO)

    fun getIceCream(): Flow<List<IceCream>> = flow {
        try {
            val response = apiServiceImpl.getIceCream()
            emit(response)
            foodDao.insertIceCream(response)
        } catch (e: Exception) {
            return@flow
        }
    }.flowOn(Dispatchers.IO)

}
package ru.borodinskiy.aleksei.menu.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.borodinskiy.aleksei.menu.entity.Burgers
import ru.borodinskiy.aleksei.menu.entity.Drinks
import ru.borodinskiy.aleksei.menu.entity.IceCream
import ru.borodinskiy.aleksei.menu.entity.Pizzas

@Dao
interface FoodDao {

    @Query("SELECT * FROM Burgers ORDER BY id DESC")
    fun getBurger(): Flow<List<Burgers>>

    @Query("SELECT * FROM Pizzas ORDER BY id DESC")
    fun getPizzas(): Flow<List<Pizzas>>

    @Query("SELECT * FROM Drinks ORDER BY id DESC")
    fun getDrinks(): Flow<List<Drinks>>

    @Query("SELECT * FROM IceCream ORDER BY id DESC")
    fun getIceCream(): Flow<List<IceCream>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBurgers(listBurgers : List<Burgers>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizzas(listBurgers : List<Pizzas>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinks(listBurgers : List<Drinks>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIceCream(listBurgers : List<IceCream>)

}
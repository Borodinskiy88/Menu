package ru.borodinskiy.aleksei.menu.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.borodinskiy.aleksei.menu.dao.FoodDao
import ru.borodinskiy.aleksei.menu.entity.Burgers
import ru.borodinskiy.aleksei.menu.entity.Drinks
import ru.borodinskiy.aleksei.menu.entity.IceCream
import ru.borodinskiy.aleksei.menu.entity.Pizzas

@Database(
    entities = [
        Burgers::class,
        Pizzas::class,
        Drinks::class,
        IceCream::class
    ], version = 1, exportSchema = false
)
abstract class FoodDatabase : RoomDatabase() {

    abstract fun foodDao(): FoodDao

}
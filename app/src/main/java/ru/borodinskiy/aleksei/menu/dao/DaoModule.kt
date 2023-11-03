package ru.borodinskiy.aleksei.menu.dao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.borodinskiy.aleksei.menu.db.FoodDatabase

@InstallIn(SingletonComponent::class)
@Module
object DaoModule {
    @Provides
    fun provideFoodDao(db: FoodDatabase): FoodDao = db.foodDao()
}
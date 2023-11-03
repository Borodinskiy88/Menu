package ru.borodinskiy.aleksei.menu.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class JokesDatabaseModule {

    @Singleton
    @Provides
    fun provideDb(
        @ApplicationContext
        context: Context
    ): FoodDatabase = Room.databaseBuilder(context, FoodDatabase::class.java, "food_db")
        .fallbackToDestructiveMigration()
        .build()
}
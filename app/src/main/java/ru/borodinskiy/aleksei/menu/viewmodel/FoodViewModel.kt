package ru.borodinskiy.aleksei.menu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.borodinskiy.aleksei.menu.entity.Burgers
import ru.borodinskiy.aleksei.menu.entity.Drinks
import ru.borodinskiy.aleksei.menu.entity.IceCream
import ru.borodinskiy.aleksei.menu.entity.Pizzas
import ru.borodinskiy.aleksei.menu.repository.FoodRepository
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val repository: FoodRepository
) : ViewModel() {

    val allBurgers = repository.allBurgers.asLiveData()
    val allPizzas = repository.allPizzas.asLiveData()
    val allDrinks = repository.allDrinks.asLiveData()
    val allIceCream = repository.allIceCream.asLiveData()

    fun getBurgers() : LiveData<List<Burgers>> = repository.getBurgers().asLiveData()
    fun getPizzas() : LiveData<List<Pizzas>> = repository.getPizzas().asLiveData()
    fun getDrinks() : LiveData<List<Drinks>> = repository.getDrinks().asLiveData()
    fun getIceCream() : LiveData<List<IceCream>> = repository.getIceCream().asLiveData()
}
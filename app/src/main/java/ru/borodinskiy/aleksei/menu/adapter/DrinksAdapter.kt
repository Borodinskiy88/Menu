package ru.borodinskiy.aleksei.menu.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.menu.databinding.CardFoodBinding
import ru.borodinskiy.aleksei.menu.entity.Drinks
import ru.borodinskiy.aleksei.menu.entity.Pizzas
import ru.borodinskiy.aleksei.menu.utils.load

class DrinksAdapter :
    ListAdapter<Drinks, DrinksAdapter.DrinksViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {


        return DrinksViewHolder(
            CardFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class DrinksViewHolder(
        private val binding: CardFoodBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(drinks: Drinks) {

            binding.apply {

                photoFood.load(drinks.img)
                headline.text = drinks.name
                textFood.text = drinks.dsc
                price.text = "от $drinks.price.toString()руб."

            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Drinks>() {
            override fun areItemsTheSame(oldItem: Drinks, newItem: Drinks): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Drinks, newItem: Drinks): Boolean {
                return oldItem == newItem
            }
        }
    }

}
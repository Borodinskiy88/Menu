package ru.borodinskiy.aleksei.menu.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.menu.databinding.CardFoodBinding
import ru.borodinskiy.aleksei.menu.entity.Pizzas
import ru.borodinskiy.aleksei.menu.utils.load

class PizzasAdapter :
    ListAdapter<Pizzas, PizzasAdapter.PizzasViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzasViewHolder {


        return PizzasViewHolder(
            CardFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PizzasViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class PizzasViewHolder(
        private val binding: CardFoodBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(pizzas: Pizzas) {

            binding.apply {

                photoFood.load(pizzas.img)
                headline.text = pizzas.name
                textFood.text = pizzas.dsc
                price.text = "от $pizzas.price.toString()руб."

            }

        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Pizzas>() {
            override fun areItemsTheSame(oldItem: Pizzas, newItem: Pizzas): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Pizzas, newItem: Pizzas): Boolean {
                return oldItem == newItem
            }
        }
    }

}
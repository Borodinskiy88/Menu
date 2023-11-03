package ru.borodinskiy.aleksei.menu.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.menu.databinding.CardFoodBinding
import ru.borodinskiy.aleksei.menu.entity.Burgers
import ru.borodinskiy.aleksei.menu.utils.load

class BurgersAdapter(
) :
    ListAdapter<Burgers, BurgersAdapter.BurgersViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurgersViewHolder {


        return BurgersViewHolder(
            CardFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BurgersViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class BurgersViewHolder(
        private val binding: CardFoodBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(burgers: Burgers) {

            binding.apply {

                photoFood.load(burgers.img)
                headline.text = burgers.name
                textFood.text = burgers.dsc
                price.text = burgers.price.toString() + " руб."

            }

        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Burgers>() {
            override fun areItemsTheSame(oldItem: Burgers, newItem: Burgers): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Burgers, newItem: Burgers): Boolean {
                return oldItem == newItem
            }
        }
    }

}
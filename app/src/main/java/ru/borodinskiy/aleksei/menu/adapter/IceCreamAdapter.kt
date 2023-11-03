package ru.borodinskiy.aleksei.menu.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.menu.databinding.CardFoodBinding
import ru.borodinskiy.aleksei.menu.entity.Drinks
import ru.borodinskiy.aleksei.menu.entity.IceCream
import ru.borodinskiy.aleksei.menu.utils.load

class IceCreamAdapter :
    ListAdapter<IceCream, IceCreamAdapter.IceCreamViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IceCreamViewHolder {


        return IceCreamViewHolder(
            CardFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: IceCreamViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class IceCreamViewHolder(
        private val binding: CardFoodBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(iceCream: IceCream) {

            binding.apply {

                photoFood.load(iceCream.img)
                headline.text = iceCream.name
                textFood.text = iceCream.dsc
                price.text = "от $iceCream.price.toString()руб."

            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<IceCream>() {
            override fun areItemsTheSame(oldItem: IceCream, newItem: IceCream): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: IceCream, newItem: IceCream): Boolean {
                return oldItem == newItem
            }
        }
    }

}
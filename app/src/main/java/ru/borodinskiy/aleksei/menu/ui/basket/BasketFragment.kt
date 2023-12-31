package ru.borodinskiy.aleksei.menu.ui.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.menu.databinding.FragmentBasketBinding

@AndroidEntryPoint
class BasketFragment : Fragment() {

    private lateinit var binding: FragmentBasketBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBasketBinding.inflate(inflater, container, false)

        return binding.root

    }
}




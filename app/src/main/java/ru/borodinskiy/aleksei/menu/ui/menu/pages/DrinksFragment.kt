package ru.borodinskiy.aleksei.menu.ui.menu.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.menu.R
import ru.borodinskiy.aleksei.menu.adapter.BurgersAdapter
import ru.borodinskiy.aleksei.menu.adapter.DrinksAdapter
import ru.borodinskiy.aleksei.menu.adapter.PizzasAdapter
import ru.borodinskiy.aleksei.menu.databinding.FragmentDrinksBinding
import ru.borodinskiy.aleksei.menu.databinding.FragmentMenuBinding
import ru.borodinskiy.aleksei.menu.viewmodel.FoodViewModel

@AndroidEntryPoint
class DrinksFragment : Fragment() {

    private lateinit var binding: FragmentDrinksBinding
    private val viewModel: FoodViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DrinksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDrinksBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = DrinksAdapter()

        recyclerView.adapter = adapter

        viewModel.getDrinks().observe(viewLifecycleOwner) {}

        viewModel.allDrinks.observe(viewLifecycleOwner) {

            adapter.submitList(it)
        }

        return binding.root
    }

}
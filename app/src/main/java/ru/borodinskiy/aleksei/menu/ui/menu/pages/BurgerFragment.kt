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
import ru.borodinskiy.aleksei.menu.databinding.FragmentBurgerBinding
import ru.borodinskiy.aleksei.menu.databinding.FragmentMenuBinding
import ru.borodinskiy.aleksei.menu.ui.menu.MenuFragment
import ru.borodinskiy.aleksei.menu.viewmodel.FoodViewModel

@AndroidEntryPoint
class BurgerFragment : Fragment() {

    private lateinit var binding: FragmentBurgerBinding
    private val viewModel: FoodViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BurgersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBurgerBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = BurgersAdapter()

        recyclerView.adapter = adapter

        viewModel.getBurgers().observe(viewLifecycleOwner) {}

        viewModel.allBurgers.observe(viewLifecycleOwner) {

            adapter.submitList(it)
        }

        return binding.root
    }

}
package ru.borodinskiy.aleksei.menu.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.menu.R
import ru.borodinskiy.aleksei.menu.adapter.ViewPagerAdapter
import ru.borodinskiy.aleksei.menu.databinding.FragmentMenuBinding

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)


        binding.viewPager.adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val feedList = listOf(
                getString(R.string.burgers),
                getString(R.string.pizza),
                getString(R.string.drinks),
                getString(R.string.ice_cream),
            )
            tab.text = feedList[position]
        }.attach()

        return binding.root
    }

}
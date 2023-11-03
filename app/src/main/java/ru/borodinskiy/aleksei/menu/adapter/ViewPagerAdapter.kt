package ru.borodinskiy.aleksei.menu.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.borodinskiy.aleksei.menu.ui.menu.pages.BurgerFragment
import ru.borodinskiy.aleksei.menu.ui.menu.pages.DrinksFragment
import ru.borodinskiy.aleksei.menu.ui.menu.pages.IceCreamFragment
import ru.borodinskiy.aleksei.menu.ui.menu.pages.PizzaFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BurgerFragment()
            1 -> PizzaFragment()
            2 -> DrinksFragment()
            3 -> IceCreamFragment()
            else -> BurgerFragment()
        }
    }
}
package com.oyoyoy.karma.peopleCarousel

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class PepleCarouselFragmentStateAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    var fragments : ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyItemInserted(fragments.size-1)
    }

    fun removeFragment() {
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }

}
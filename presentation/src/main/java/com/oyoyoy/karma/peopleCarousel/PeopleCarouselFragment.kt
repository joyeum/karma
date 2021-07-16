package com.oyoyoy.karma.peopleCarousel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.oyoyoy.karma.R
import com.oyoyoy.karma.base.BaseFragment
import com.oyoyoy.karma.databinding.FragmentPeopleCarouselBinding
import com.oyoyoy.karma.peopleCarousel.test.TestGreenFragment
import com.oyoyoy.karma.peopleCarousel.test.TestRedFragment

//UI와 관련된 코드
class PeopleCarouselFragment: BaseFragment<FragmentPeopleCarouselBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_people_carousel
    private lateinit var viewModel: PeopleCarouselViewModel
    private lateinit var vpAdapter: PeopleCarouselFragmentStateAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = PeopleCarouselViewModel()
        viewDataBinding.viewModel = viewModel

        viewLifecycleOwner.lifecycle.addObserver(viewModel)
        vpAdapter = PeopleCarouselFragmentStateAdapter(this)
        viewDataBinding.adapter = vpAdapter

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vpAdapter.addFragment(TestRedFragment())
        Log.d("debugging","red")
        vpAdapter.addFragment(TestGreenFragment())


    }

}

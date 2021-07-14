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
//UI와 관련된 코드
class PeopleCarouselFragment: BaseFragment<FragmentPeopleCarouselBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_people_carousel
    private lateinit var viewModel: PeopleCarouselViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = PeopleCarouselViewModel()
        viewDataBinding.viewModel = viewModel

        viewLifecycleOwner.lifecycle.addObserver(viewModel)
    }

    ///아래코드를 데이터 바인딩으로 해보자
/*
        val pagerAdapter = PagerFragmentStateAdapter(this)
        viewPager.adapter = pagerAdapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people_carousel, container, false)
    }*/


}
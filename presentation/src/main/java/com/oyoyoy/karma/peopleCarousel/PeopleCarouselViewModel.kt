package com.oyoyoy.karma.peopleCarousel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.widget.ViewPager2
import com.oyoyoy.karma.base.BaseViewModel
import com.oyoyoy.karma.peopleCarousel.test.TestGreenFragment
import com.oyoyoy.karma.peopleCarousel.test.TestRedFragment

//데이터를 준비하는 코드
class PeopleCarouselViewModel : BaseViewModel() {

    val tabItems: LiveData<List<String>> get() = _tabItems
    val position: LiveData<Int> get() = _position


    private val _tabItems: MutableLiveData<List<String>> = MutableLiveData(listOf("Red"))
    private val _position: MutableLiveData<Int> = MutableLiveData(0)


    override fun onCreate() {

        super.onCreate()
        Log.d("debug", "onCreate")

    }

    override fun onStart() {
        super.onStart()
        /*
        val pagerAdapter = PepleCarouselFragmentStateAdapter()
        // 3개의 Fragment Add
        pagerAdapter.addFragment(TestRedFragment())
        pagerAdapter.addFragment(TestGreenFragment())
        // Adapter
        viewPager.adapter = pagerAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("ViewPagerFragment", "Page ${position+1}")
            }
        })
        */

    }

}
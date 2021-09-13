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




    val tabItems: MutableLiveData<List<String>> = MutableLiveData(listOf("Red"))
    val position: MutableLiveData<Int> = MutableLiveData(0)


    override fun onCreate() {

        super.onCreate()


    }

    override fun onStart() {
        super.onStart()



    }

}
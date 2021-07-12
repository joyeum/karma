package com.oyoyoy.karma

import android.util.Log
import androidx.lifecycle.ViewModel
import com.oyoyoy.karma.base.BaseViewModel

class PeopleCarouselViewModel : BaseViewModel() {

    override fun onCreate() {
        super.onCreate()
        Log.d("debug", "onCreate")
    }
}
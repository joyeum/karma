package com.oyoyoy.karma

import android.app.Activity.RESULT_CANCELED
import android.content.Intent
import android.text.TextUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oyoyoy.karma.base.BaseViewModel

class EnrollPersonViewModel:BaseViewModel() {
    var editPersonName : MutableLiveData<String> = MutableLiveData("")
    var editPersonContent : MutableLiveData<String> = MutableLiveData("")
    var enrollClick : MutableLiveData<Unit> = MutableLiveData()

    override fun onCreate() {
        super.onCreate()
    }


    fun onButtonClick(){
        enrollClick.value = null

    }

}
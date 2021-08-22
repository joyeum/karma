package com.oyoyoy.karma

import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import com.oyoyoy.domain.data.Person
import com.oyoyoy.karma.base.BaseViewModel


class EnrollPersonViewModel:BaseViewModel() {
    var editPersonName : MutableLiveData<String> = MutableLiveData("")
    var editPersonContent : MutableLiveData<String> = MutableLiveData("")
    var enrollClick : MutableLiveData<Unit> = MutableLiveData()

    private var listener: EnrollPersonFragment.OnResultListener? = null


    fun setListener(listener: EnrollPersonFragment.OnResultListener) {
        this.listener = listener
    }
    override fun onCreate() {
        super.onCreate()
    }

    fun onButtonClick(){
        if (editPersonName.value.toString() == ""){
            //저장할 수 없다고 알려주기
        }

        else {
            val person = Person(editPersonName.value.toString(), editPersonContent.value.toString(),1111)
            listener?.onResult(person)
        }
        enrollClick.value = null
    }
}
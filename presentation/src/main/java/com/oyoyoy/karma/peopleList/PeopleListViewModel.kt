package com.oyoyoy.karma.peopleList

import androidx.lifecycle.MutableLiveData
import com.oyoyoy.karma.base.BaseViewModel
import com.oyoyoy.karma.peopleList.test.Person

class PeopleListViewModel : BaseViewModel() {
    var peopleList : MutableLiveData<List<Person>> = MutableLiveData()

    override fun onCreate() {
        super.onCreate()
    }

}
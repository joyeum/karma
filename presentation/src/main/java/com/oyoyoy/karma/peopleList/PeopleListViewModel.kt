package com.oyoyoy.karma.peopleList


import androidx.lifecycle.*
import com.oyoyoy.domain.data.EntityPerson
import com.oyoyoy.domain.repository.GetCursePeopleRepository

import kotlinx.coroutines.launch


class PeopleListViewModel(private val repository: GetCursePeopleRepository) : ViewModel(), LifecycleObserver {

    //val peopleListData = MutableLiveData<List<Person>>()
    val cursePeople: LiveData<List<EntityPerson>> = repository.allPeople.asLiveData()

    init {
        /*
        var temp1 = Person("one","test1",11111)
        var temp2 = Person("two","test2",22222)
        var temp3 = Person("three","test3",33333)

        //peopleList.value = listOf(temp1,temp2,temp3)
        addItem(temp1)
        addItem(temp2)
        addItem(temp3)
        */

        //Log.d("debugging",peopleList.toString())
        fun insert(person:EntityPerson) = viewModelScope.launch {
            repository.insert(person)

        }


    }
}

class PeopleListVieModelFactory(private val repository: GetCursePeopleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PeopleListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PeopleListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
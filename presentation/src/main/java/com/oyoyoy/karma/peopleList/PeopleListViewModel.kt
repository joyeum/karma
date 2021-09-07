package com.oyoyoy.karma.peopleList


import android.util.Log
import androidx.lifecycle.*
import com.oyoyoy.domain.data.Person
import com.oyoyoy.karma.EnrollPersonFragment
import com.oyoyoy.karma.KarmaApplication.Companion.instance
import kotlinx.coroutines.launch


class PeopleListViewModel() : ViewModel(), LifecycleObserver {
    private val repository = instance.repository
    val cursePeople: LiveData<List<Person>> = repository.allPeople.asLiveData()


    fun insert(person:Person) = viewModelScope.launch {
        repository.insert(person)
    }
}
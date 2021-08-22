package com.oyoyoy.karma.peopleList


import androidx.lifecycle.*
import com.oyoyoy.domain.data.Person
import com.oyoyoy.domain.repository.GetCursePeopleRepository

import kotlinx.coroutines.launch


class PeopleListViewModel(private val repository: GetCursePeopleRepository) : ViewModel(), LifecycleObserver {

    val cursePeople: LiveData<List<Person>> = repository.allPeople.asLiveData()

    fun insert(person:Person) = viewModelScope.launch {
        repository.insert(person)
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
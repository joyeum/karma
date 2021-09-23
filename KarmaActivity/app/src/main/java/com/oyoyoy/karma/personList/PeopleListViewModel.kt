package com.oyoyoy.karma.personList

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oyoyoy.karma.data.DataSource
import com.oyoyoy.karma.data.Person
import kotlin.random.Random

class PeopleListViewModel(val dataSource: DataSource) : ViewModel() {
    val peopleLiveData = dataSource.getPeopleList()

    fun insertPerson(personName: String?, personDescription: String?) {
        if (personName == null || personDescription == null) {
            return
        }

        val image = dataSource.getRandomPersonImageAsset()
        val newPerson = Person(
            Random.nextLong(),
            personName,
            image,
            personDescription
        )
        dataSource.addPerson(newPerson)
    }

}

class PeopleListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PeopleListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PeopleListViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
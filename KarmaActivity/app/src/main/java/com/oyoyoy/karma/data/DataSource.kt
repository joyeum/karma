package com.oyoyoy.karma.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources) {
    private val initialPersonList = personList(resources)
    private val peopleLiveData = MutableLiveData(initialPersonList)

    fun getPeopleList(): LiveData<List<Person>> {
        return peopleLiveData
    }
    fun getRandomPersonImageAsset(): Int? {
        val randomNumber = (initialPersonList.indices).random()
        return initialPersonList[randomNumber].image
    }
    /* Adds person to liveData and posts value. */
    fun addPerson(person: Person) {
        val currentList = peopleLiveData.value
        if (currentList == null) {
            peopleLiveData.postValue(listOf(person))
        }
        else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, person)
            peopleLiveData.postValue(updatedList)
        }
    }

    /* Removes person from liveData and posts value. */
    fun removePerson(person: Person) {
        val currentList = peopleLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(person)
            peopleLiveData.postValue(updatedList)
        }
    }

    /* Returns person given an ID. */
    fun getPersonForId(id: Long): Person? {
        peopleLiveData.value?.let { people ->
            return people.firstOrNull{ it.id == id}
        }
        return null
    }



    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}
package com.oyoyoy.domain.repository

import androidx.annotation.WorkerThread
import com.oyoyoy.domain.data.Person
import com.oyoyoy.domain.data.PersonDao
import kotlinx.coroutines.flow.Flow

class GetCursePeopleRepository(private val personDao: PersonDao) {
    val allPeople: Flow<List<Person>> = personDao.getCursePeople()


    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(person: Person) {
        personDao.insert(person)
    }
}
package com.oyoyoy.domain.repository

import androidx.annotation.WorkerThread
import com.oyoyoy.domain.data.EntityPerson
import com.oyoyoy.domain.data.PersonDao
import kotlinx.coroutines.flow.Flow

class GetCursePeopleRepository(private val personDao: PersonDao) {
    val allPeople: Flow<List<EntityPerson>> = personDao.getCursePeople()


    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(person: EntityPerson) {
        personDao.insert(person)
    }
}
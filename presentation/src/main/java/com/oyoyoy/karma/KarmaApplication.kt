package com.oyoyoy.karma

import android.app.Application
import com.oyoyoy.domain.repository.GetCursePeopleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class KarmaApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { PersonRoomDatabase.getDatabase(this,applicationScope) }
    val repository: GetCursePeopleRepository by lazy { GetCursePeopleRepository(database.personDao()) }

    companion object {
        lateinit var instance: KarmaApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
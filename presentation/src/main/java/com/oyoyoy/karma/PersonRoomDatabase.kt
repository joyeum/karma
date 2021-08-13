package com.oyoyoy.karma

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.oyoyoy.domain.data.EntityPerson
import com.oyoyoy.domain.data.PersonDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Person class
@Database(entities = arrayOf(EntityPerson::class), version = 1, exportSchema = false)
public abstract class PersonRoomDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao
    private class PersonDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                database -> scope.launch {
                    var personDao = database.personDao()

                    // TODO: Add your own words!
                    var person = EntityPerson("one","test1",11111 )
                    personDao.insert(person)
                }
            }

        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PersonRoomDatabase? = null

        fun getDatabase(context: Context, scope : CoroutineScope): PersonRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonRoomDatabase::class.java,
                    "people_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
package com.oyoyoy.domain.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Person class
@Database(entities = arrayOf(EntityPerson::class), version = 1, exportSchema = false)
public abstract class PersonRoomDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PersonRoomDatabase? = null

        fun getDatabase(context: Context): PersonRoomDatabase {
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
package com.oyoyoy.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oyoyoy.domain.entity.Person


@Dao
interface PersonDao {
    @Query("SELECT * FROM people_table ORDER BY name ASC")
    fun getAlphabetizedWords(): List<Person>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(person: Person)

    @Query("DELETE FROM people_table")
    suspend fun deleteAll()
}


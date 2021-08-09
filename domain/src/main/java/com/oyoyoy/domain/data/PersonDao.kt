package com.oyoyoy.domain.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oyoyoy.domain.data.EntityPerson
import kotlinx.coroutines.flow.Flow


@Dao
interface PersonDao {
    @Query("SELECT * FROM people_table ORDER BY name ASC")
    fun getCursePeople(): Flow<List<EntityPerson>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(person: EntityPerson)

    @Query("DELETE FROM people_table")
    suspend fun deleteAll()
}


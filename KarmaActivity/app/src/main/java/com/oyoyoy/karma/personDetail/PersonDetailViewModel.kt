package com.oyoyoy.karma.personDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oyoyoy.karma.data.DataSource
import com.oyoyoy.karma.data.Person

class PersonDetailViewModel(private val datasource: DataSource) : ViewModel()  {
    fun getPersonForId (id: Long) : Person? {
        return datasource.getPersonForId(id)
    }

    /* Queries datasource to remove a flower. */
    fun removePerson (person: Person) {
        datasource.removePerson(person)
    }

}


class PersonDetailViewModelFactory (private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PersonDetailViewModel(
                datasource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
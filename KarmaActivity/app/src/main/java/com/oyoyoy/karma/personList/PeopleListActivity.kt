package com.oyoyoy.karma.personList

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter

import androidx.recyclerview.widget.RecyclerView
import com.oyoyoy.karma.R
import com.oyoyoy.karma.data.Person
import com.oyoyoy.karma.personDetail.PersonDetailActivity


const val PERSON_ID = "person id"

class PeopleListActivity : AppCompatActivity(){
    private val peopleListViewModel by viewModels<PeopleListViewModel> {
        PeopleListViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_list)
        val headerAdapter = HeaderAdapter()
        val peopleAdapter = PeopleAdapter { person -> adapterOnClick(person) }
        val concatAdapter = ConcatAdapter(headerAdapter,peopleAdapter)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = concatAdapter
        peopleListViewModel.peopleLiveData.observe(this, {
            it?.let {
                peopleAdapter.submitList(it as MutableList<Person>)
            }
        })

    }

    private fun adapterOnClick(person: Person) {
        //Log.d("JoyDoyToy", "isClicked")
        val intent = Intent(this, PersonDetailActivity()::class.java)
        intent.putExtra(PERSON_ID, person.id)
        startActivity(intent)
    }
}

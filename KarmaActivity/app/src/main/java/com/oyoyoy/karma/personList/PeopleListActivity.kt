package com.oyoyoy.karma.personList

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter

import androidx.recyclerview.widget.RecyclerView
import com.oyoyoy.karma.R
import com.oyoyoy.karma.data.Person
import com.oyoyoy.karma.enrollPerson.EnrollPersonActivity
import com.oyoyoy.karma.enrollPerson.PERSON_DESCRIPTION
import com.oyoyoy.karma.enrollPerson.PERSON_NAME
import com.oyoyoy.karma.personDetail.PersonDetailActivity


const val PERSON_ID = "person id"

class PeopleListActivity : AppCompatActivity(){
    private val newPersonActivityRequestCode = 1
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

        val fab : View = findViewById(R.id.fab)
        fab.setOnClickListener{
            fabOnClick()
        }
        recyclerView.adapter = peopleAdapter
        peopleListViewModel.peopleLiveData.observe(this, {
            it?.let {
                peopleAdapter.submitList(it as MutableList<Person>)
                headerAdapter.updatePersonCount(it.size)
            }
        })
    }


    private fun adapterOnClick(person: Person) {
        //Log.d("JoyDoyToy", "isClicked")
        val intent = Intent(this, PersonDetailActivity()::class.java)
        intent.putExtra(PERSON_ID, person.id)
        startActivity(intent)
    }

    private fun fabOnClick() {
//        TODO("startActivityForResult is deprecated")
        val intent = Intent(this, EnrollPersonActivity::class.java)
        startActivityForResult(intent, newPersonActivityRequestCode)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newPersonActivityRequestCode && resultCode == Activity.RESULT_OK){
            intentData?.let { data ->
                val personName = data.getStringExtra(PERSON_NAME)
                val personDescription = data.getStringExtra(PERSON_DESCRIPTION)
                peopleListViewModel.insertPerson(personName, personDescription )
            }
        }


    }
}

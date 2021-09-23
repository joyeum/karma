package com.oyoyoy.karma.personDetail

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.oyoyoy.karma.R
import com.oyoyoy.karma.personList.PERSON_ID

class PersonDetailActivity : AppCompatActivity() {
    private val personDetailViewModel by viewModels<PersonDetailViewModel> {
        PersonDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_person_detail)
        val personNameView : TextView = findViewById(R.id.n)
        val removePersonButton : Button = findViewById(R.id.remove_button)

        var currentPersonId: Long? = null

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentPersonId = bundle.getLong(PERSON_ID)
        }

        currentPersonId?.let {
            val currentPerson = personDetailViewModel.getPersonForId(it)


        }

        removePersonButton.setOnClickListener {
            personDetailViewModel.removePerson(it)
        }



        TODO("Refactoring by using Data Binding joydoytoy")
    }

}

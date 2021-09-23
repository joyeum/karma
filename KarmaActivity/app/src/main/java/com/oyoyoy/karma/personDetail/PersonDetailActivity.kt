package com.oyoyoy.karma.personDetail

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        setContentView(R.layout.activity_person_detail)
        val personName : TextView = findViewById(R.id.person_detail_name)
        val personDescription : TextView = findViewById(R.id.person_detail_description)
        val personImage : ImageView = findViewById(R.id.person_detail_image)

        val removePersonButton : Button = findViewById(R.id.remove_button)

        var currentPersonId: Long? = null

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentPersonId = bundle.getLong(PERSON_ID)
        }

        currentPersonId?.let {
            val currentPerson = personDetailViewModel.getPersonForId(it)
            personName.text = currentPerson?.name
            personDescription.text = currentPerson?.description
            if (currentPerson?.image != null) {
                personImage.setImageResource(currentPerson.image)
            } else {
                personImage.setImageResource(R.drawable.rose)
            }
            removePersonButton.setOnClickListener {
                if (currentPerson != null) {
                    personDetailViewModel.removePerson(currentPerson)
                }
            }
        }





        TODO("Refactoring by using Data Binding joydoytoy")
    }

}

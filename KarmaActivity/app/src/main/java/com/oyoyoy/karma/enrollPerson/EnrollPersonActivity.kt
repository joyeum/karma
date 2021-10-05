package com.oyoyoy.karma.enrollPerson

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.oyoyoy.karma.R

const val PERSON_NAME = "name"
const val PERSON_DESCRIPTION = "description"


class EnrollPersonActivity :AppCompatActivity() {
    //TODO("Refactoring by using Data Binding joydoytoy")

    private lateinit var addPersonName : TextInputEditText
    private lateinit var addPersonDescription : TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enroll_person)
        addPersonName = findViewById(R.id.add_person_name)
        addPersonDescription = findViewById(R.id.add_person_description)
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addPerson()
        }
    }
    private fun addPerson(){
        val resultIntent = Intent()

        if ( addPersonName.text.isNullOrBlank() || addPersonDescription.text.isNullOrEmpty() ) {
            setResult(Activity.RESULT_CANCELED, resultIntent)
        }
        else {
            val name = addPersonName.text.toString()
            val description = addPersonDescription.text.toString()
            resultIntent.putExtra(PERSON_NAME, name)
            resultIntent.putExtra(PERSON_DESCRIPTION, description)
            setResult(Activity.RESULT_OK, resultIntent)

        }
        finish()
    }



}
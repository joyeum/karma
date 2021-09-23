package com.oyoyoy.karma.personList

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oyoyoy.karma.R
import com.oyoyoy.karma.data.Person

class PeopleAdapter(private val onClick: (Person) -> Unit)
    : ListAdapter<Person, PeopleAdapter.PersonViewHolder>(PersonDiffCallback) {

    class PersonViewHolder(itemView: View, val onClick: (Person) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val personNameView: TextView = itemView.findViewById(R.id.person_name)
        private val personImageView: ImageView = itemView.findViewById(R.id.person_image)
        private var currentPerson: Person? = null
        init {
            itemView.setOnClickListener {
                currentPerson?.let {
                    onClick(it)
                }
            }
        }
        fun bind(person: Person) {
            currentPerson = person
            personNameView.text = person.name
            if (person.image != null) {
                personImageView.setImageResource(person.image)
            }
            else {
                Log.d("JoyDoyToy", "No Image in this item")
                //personImageView.setImageResource(R.drawable.rose)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = getItem(position)
        holder.bind(person)
    }
}
object PersonDiffCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }
}
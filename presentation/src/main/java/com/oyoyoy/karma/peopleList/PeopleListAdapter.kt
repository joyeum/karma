package com.oyoyoy.karma.peopleList

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.oyoyoy.karma.R
import com.oyoyoy.karma.peopleList.test.Person

class PeopleListAdapter(var people: LiveData<List<Person>>): RecyclerView.Adapter<PeopleListAdapter.PersonHolder>() {
    inner class PersonHolder constructor(parent: ViewGroup)
        : RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.item_people_list, parent, false)) {
        var name = itemView.textF
        var content = itemView.textS
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleListAdapter.PersonHolder {
        return PersonHolder(parent)
    }

    override fun onBindViewHolder(holder: PeopleListAdapter.PersonHolder, position: Int) {
        people.value!!.get(position).let { item ->
            with(holder) {
                name.text = item.name
                content.text = item.content
                Log.e("TextSet", name.text.toString() + content.text.toString())
            }
        }
    }

    override fun getItemCount(): Int {
       // Log.e("datasize", "" + people.value!!.size)
        return people.value!!.size
    }
}

package com.oyoyoy.karma.peopleList

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.oyoyoy.karma.R


class PeopleListAdapter(var people: MutableLiveData<List<Person>>): RecyclerView.Adapter<PeopleListAdapter.PersonHolder>() {
    inner class PersonHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var textViewName : TextView = itemView.findViewById(R.id.name)
        var textViewContent : TextView = itemView.findViewById(R.id.content)
        var textViewTime : TextView = itemView.findViewById(R.id.time)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleListAdapter.PersonHolder {
/*
        var temp1 = Person("one","test1",11111)
        var temp2 = Person("two","test2",22222)
        var temp3 = Person("three","test3",33333)

        people.value = listOf(temp1,temp2,temp3)*/
        people.value = emptyList()
        Log.d("debugging", people.value.toString())


        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people_list, parent, false)
        return PersonHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleListAdapter.PersonHolder, position: Int) {
        people.value!!.get(position).let { item ->
            with(holder) {
                textViewName.text = item.name
                textViewContent.text = item.content
                textViewTime.text = item.timestamp.toString()

                Log.e("TextSet", textViewName.text.toString() + textViewContent.text.toString())
            }
        }
    }

    override fun getItemCount(): Int {
       Log.e("datasize", "" + people.value!!.size)
        return people.value!!.size
    }

    fun setList(input:MutableLiveData<List<Person>>){
        people.value = input.value
        notifyDataSetChanged()


    }
}

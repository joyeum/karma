package com.oyoyoy.karma.peopleList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oyoyoy.domain.data.Person
import com.oyoyoy.karma.R


class PeopleListAdapter : ListAdapter<Person, PeopleListAdapter.PersonViewHolder>(WordsComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
/*
        var temp1 = Person("one","test1",11111)
        var temp2 = Person("two","test2",22222)
        var temp3 = Person("three","test3",33333)
*/
        return PersonViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val current = getItem(position)
        holder.bindName(current.name)
        holder.bindContent(current.content)
        holder.bindTime(current.timestamp)

    }

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewName : TextView = itemView.findViewById(R.id.name)
        private val textViewContent : TextView = itemView.findViewById(R.id.content)
        private val textViewTime : TextView = itemView.findViewById(R.id.time)

        fun bindName(text: String?) {
            textViewName.text = text
        }

        fun bindContent(text: String?) {
            textViewContent.text = text
        }
        fun bindTime(timestamp: Int?) {
            textViewTime.text = timestamp.toString()
        }
        companion object {
            fun create(parent: ViewGroup): PersonViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_people_list, parent, false)
                return PersonViewHolder(view)
            }
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.name == newItem.name
        }
    }
}
/*
class PeopleListAdapter(var people: MutableLiveData<List<Person>>): RecyclerView.Adapter<PeopleListAdapter.PersonHolder>() {
    inner class PersonHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var textViewName : TextView = itemView.findViewById(R.id.name)
        var textViewContent : TextView = itemView.findViewById(R.id.content)
        var textViewTime : TextView = itemView.findViewById(R.id.time)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleListAdapter.PersonHolder {

        var temp1 = Person("one","test1",11111)
        var temp2 = Person("two","test2",22222)
        var temp3 = Person("three","test3",33333)

        people.value = listOf(temp1,temp2,temp3)
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
*/
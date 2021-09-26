package com.oyoyoy.karma.personList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oyoyoy.karma.R

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private var personCount: Int = 0
    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val personCountView : TextView = itemView.findViewById(R.id.person_count_text)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): HeaderAdapter.HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_header,parent,false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderAdapter.HeaderViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return 1
    }
}
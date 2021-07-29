package com.oyoyoy.karma.peopleList


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oyoyoy.karma.R



class PeopleListFragment : Fragment() {

    private lateinit var viewModel: PeopleListViewModel
    private lateinit var peopleList : RecyclerView
    private lateinit var peopleListAdapter: PeopleListAdapter
    private lateinit var navController : NavController
    private lateinit var button: Button
    /*
    lateinit var viewDataBinding: FragmentPeopleListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_people_list, container, false)
        viewDataBinding.lifecycleOwner = this
        return viewDataBinding.root
    }*/


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_people_list, container,false)
        peopleList = rootView.findViewById<RecyclerView>(R.id.peopleList)
        button = rootView.findViewById(R.id.buttonMove)
        return rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        peopleList.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        // RecyclerView.adapter에 지정
        viewModel = PeopleListViewModel()
        peopleList.adapter = PeopleListAdapter(viewModel.peopleList)
        navController = findNavController()

        button.setOnClickListener {
            navController.navigate(R.id.action_PeopleList_to_EnrollPerson)

        }


        //peopleList.setAdapter(viewModel.personAdapter)

        //viewDataBinding.viewModel = viewModel


        //viewLifecycleOwner.lifecycle.addObserver(viewModel)
        /*
        viewModel.peopleList.observe(viewLifecycleOwner, Observer {
            //Adapter 업데이트 되도록
            Log.d("debugging",it.toString())
        })*/

    }
    fun moveToEnrollPerson(){

    }
}
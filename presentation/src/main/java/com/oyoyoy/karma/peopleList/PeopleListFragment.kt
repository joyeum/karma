package com.oyoyoy.karma.peopleList


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oyoyoy.karma.R
import com.oyoyoy.karma.base.BaseFragment
import com.oyoyoy.karma.databinding.FragmentPeopleListBinding

class PeopleListFragment : BaseFragment<FragmentPeopleListBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_people_list

    lateinit var viewModel: PeopleListViewModel
    private lateinit var peopleListRv : RecyclerView
    private lateinit var peopleListAdapter: PeopleListAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = PeopleListViewModel()
        viewDataBinding.viewModel = viewModel


        viewLifecycleOwner.lifecycle.addObserver(viewModel)

//        peopleListRv.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        // RecyclerView.adapter에 지정

        val rootView = viewDataBinding.root
        peopleListRv = rootView.findViewById<RecyclerView>(R.id.peopleList)
        peopleListAdapter = PeopleListAdapter(viewModel.peopleListData)
        peopleListRv.adapter = peopleListAdapter


        //peopleList.setAdapter(viewModel.personAdapter)

        //viewDataBinding.viewModel = viewModel


        //viewLifecycleOwner.lifecycle.addObserver(viewModel)
        /*
        viewModel.peopleList.observe(viewLifecycleOwner, Observer {
            //Adapter 업데이트 되도록
            Log.d("debugging",it.toString())
        })*/


    }

    /*
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewDataBinding.root
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_people_list, container,false)
        peopleList = rootView.findViewById<RecyclerView>(R.id.peopleList)
        return rootView
    }*/
}
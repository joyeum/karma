package com.oyoyoy.karma.peopleList


import android.os.Bundle
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
import com.oyoyoy.domain.data.Person
import com.oyoyoy.karma.*
import android.util.Log
import androidx.fragment.app.commit


class PeopleListFragment : Fragment(), EnrollPersonFragment.OnResultListener {


    private val viewModel = PeopleListViewModel()

    private lateinit var peopleList : RecyclerView
    private lateinit var adapter: PeopleListAdapter
    private lateinit var navController : NavController
    private lateinit var buttonMove: Button

    private val newWordActivityRequestCode = 1

    override fun onResult(inputP: Person) {
        viewModel.insert(inputP)
        Log.d("debugging", inputP.name) //여기까지 안온다

        // Fragment가 Visible 중일때만 처리


    }

    private fun showEnrollPersonFragment() {
        parentFragmentManager.commit {
            replace(R.id.layout_container, EnrollPersonFragment().apply {
                setListener(this@PeopleListFragment)
            })
            addToBackStack(null)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_people_list, container,false)
        buttonMove = rootView.findViewById(R.id.buttonMove)
        peopleList = rootView.findViewById<RecyclerView>(R.id.peopleList)

        peopleList.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        adapter = PeopleListAdapter()
        peopleList.adapter = adapter

        navController = findNavController()

        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //viewLifecycleOwner.lifecycle.addObserver(viewModel)


        val restoreValue = arguments?.getString(keyRestore)
        if (restoreValue != null) {
            /** action to do something */
        }




        viewModel.cursePeople.observe(viewLifecycleOwner, Observer{ people ->
            people.let { adapter.submitList(it) }
            })

        buttonMove.setOnClickListener {
            showEnrollPersonFragment()
            //navController.navigate(R.id.action_PeopleList_to_EnrollPerson)
        }
    }






    companion object {
        private const val keyRestore = "resultRestore"
    }


}



        /*
lateinit var viewDataBinding: FragmentPeopleListBinding
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_people_list, container, false)
    viewDataBinding.lifecycleOwner = this
    return viewDataBinding.root
}*/


        //peopleList.setAdapter(viewModel.personAdapter)

        //viewDataBinding.viewModel = viewModel


        //viewLifecycleOwner.lifecycle.addObserver(viewModel)
        /*
        viewModel.peopleList.observe(viewLifecycleOwner, Observer {
            //Adapter 업데이트 되도록
            Log.d("debugging",it.toString())
        })*/


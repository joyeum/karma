package com.oyoyoy.karma.peopleList


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.oyoyoy.karma.R
import com.oyoyoy.karma.base.BaseFragment
import com.oyoyoy.karma.databinding.FragmentPeopleListBinding


class PeopleListFragment: BaseFragment<FragmentPeopleListBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_people_list
    private lateinit var viewModel: PeopleListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = PeopleListViewModel()
        viewDataBinding.viewModel = viewModel
        viewLifecycleOwner.lifecycle.addObserver(viewModel)

        viewModel.peopleList.observe(viewLifecycleOwner, Observer {
            //Adapter 업데이트 되도록
        })
    }
}
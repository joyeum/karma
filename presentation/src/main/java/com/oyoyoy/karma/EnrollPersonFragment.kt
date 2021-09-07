package com.oyoyoy.karma

import android.os.Bundle
import android.view.View

import com.oyoyoy.karma.base.BaseFragment
import com.oyoyoy.karma.databinding.FragmentEnrollPersonBinding
import androidx.lifecycle.Observer
import com.oyoyoy.domain.data.Person

class EnrollPersonFragment: BaseFragment<FragmentEnrollPersonBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_enroll_person

    interface OnResultListener {
        fun onResult(value: Person)
    }


    private var listener: OnResultListener? = null


    fun setListener(listener: OnResultListener) {
        this.listener = listener
    }
    lateinit var viewModel: EnrollPersonViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = EnrollPersonViewModel()
        viewDataBinding.viewModel = viewModel
        viewLifecycleOwner.lifecycle.addObserver(viewModel)

        //editPersonName = view.findViewById(R.id.editPersonName)
        //editPersonContent = view.findViewById(R.id.editPersonContent)
        //buttonEnroll = view.findViewById(R.id.buttonEnroll)
        //parentFragmentManager.popBackStack()

        viewModel.enrollClick.observe(viewLifecycleOwner, Observer {
            navController.navigate(R.id.action_EnrollPerson_to_PeopleList)
        })

    }



}
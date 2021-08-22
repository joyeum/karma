package com.oyoyoy.karma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf

import com.oyoyoy.karma.base.BaseFragment
import com.oyoyoy.karma.databinding.FragmentEnrollPersonBinding
import androidx.lifecycle.Observer
import com.oyoyoy.domain.data.Person

class EnrollPersonFragment: BaseFragment<FragmentEnrollPersonBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_enroll_person

    //private lateinit var editPersonName: EditText
    //private lateinit var editPersonContent: EditText
    //private lateinit var buttonEnroll : Button
    //navController = findNavController()

    interface OnResultListener {
        fun onResult(value: Person)
    }


    lateinit var viewModel: EnrollPersonViewModel



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = EnrollPersonViewModel()
        //editPersonName = view.findViewById(R.id.editPersonName)
        //editPersonContent = view.findViewById(R.id.editPersonContent)
        //buttonEnroll = view.findViewById(R.id.buttonEnroll)
        //parentFragmentManager.popBackStack()

        viewModel.enrollClick.observe(viewLifecycleOwner, Observer {
            navController.navigate(R.id.action_EnrollPerson_to_PeopleList)
        })

    }



}
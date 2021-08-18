package com.oyoyoy.karma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.oyoyoy.karma.base.BaseFragment
import com.oyoyoy.karma.databinding.FragmentEnrollPersonBinding
import java.util.Observer

class EnrollPersonFragment: BaseFragment<FragmentEnrollPersonBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_enroll_person

    //private lateinit var editPersonName: EditText
    //private lateinit var editPersonContent: EditText
    lateinit var viewModel: EnrollPersonViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = EnrollPersonViewModel()
        //editPersonName = view.findViewById(R.id.editPersonName)
        //editPersonContent = view.findViewById(R.id.editPersonContent)
        viewModel.enrollClick.observe(viewLifecycleOwner, Observer {
            //navController.navigate(R.id.action_test1Fragment_to_randomFragment)
            setFragmentResult("requestKey", bundleOf("key" to viewModel.))

        })

    }





}
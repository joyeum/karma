package com.oyoyoy.karma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.oyoyoy.karma.base.BaseFragment
import com.oyoyoy.karma.databinding.FragmentEnrollPersonBinding

class EnrollPersonFragment: BaseFragment<FragmentEnrollPersonBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_enroll_person

    private lateinit var editPersonName: EditText
    private lateinit var editPersonContent: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {




        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editPersonName = view.findViewById(R.id.editPersonName)
        editPersonContent = view.findViewById(R.id.editPersonContent)


    }


}
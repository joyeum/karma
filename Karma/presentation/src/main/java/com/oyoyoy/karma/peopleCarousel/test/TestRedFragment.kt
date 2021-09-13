package com.oyoyoy.karma.peopleCarousel.test

import android.os.Bundle
import android.view.View
import com.oyoyoy.karma.R
import com.oyoyoy.karma.base.BaseFragment
import com.oyoyoy.karma.databinding.FragmentTestRedBinding


class TestRedFragment: BaseFragment<FragmentTestRedBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_test_red
    private lateinit var viewModel: TestRedViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = TestRedViewModel()
        viewDataBinding.viewModel = viewModel
        viewLifecycleOwner.lifecycle.addObserver(viewModel)
    }
}
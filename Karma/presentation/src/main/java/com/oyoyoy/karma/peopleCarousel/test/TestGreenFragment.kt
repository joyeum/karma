package com.oyoyoy.karma.peopleCarousel.test

import android.os.Bundle
import android.view.View
import com.oyoyoy.karma.R
import com.oyoyoy.karma.base.BaseFragment
import com.oyoyoy.karma.databinding.FragmentTestGreenBinding


class TestGreenFragment: BaseFragment<FragmentTestGreenBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_test_green
    private lateinit var viewModel: TestGreenViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = TestGreenViewModel()
        viewDataBinding.viewModel = viewModel
        viewLifecycleOwner.lifecycle.addObserver(viewModel)
    }
}
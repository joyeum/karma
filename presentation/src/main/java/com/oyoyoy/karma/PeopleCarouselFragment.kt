package com.oyoyoy.karma

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oyoyoy.karma.base.BaseFragment
import com.oyoyoy.karma.databinding.FragmentPeopleCarouselBinding

class PeopleCarouselFragment: BaseFragment<FragmentPeopleCarouselBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_people_carousel
    private lateinit var viewModel: PeopleCarouselViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = PeopleCarouselViewModel()
        viewDataBinding.viewModel = viewModel

        viewLifecycleOwner.lifecycle.addObserver(viewModel)
    }




}
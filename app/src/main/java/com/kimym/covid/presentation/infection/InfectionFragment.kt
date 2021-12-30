package com.kimym.covid.presentation.infection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.kimym.covid.R
import com.kimym.covid.base.BaseFragment
import com.kimym.covid.databinding.FragmentInfectionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfectionFragment : BaseFragment<FragmentInfectionBinding>(R.layout.fragment_infection) {
    private val viewModel by viewModels<InfectionViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding.rvInfection) {
            adapter = InfectionAdapter()
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }
    }
}

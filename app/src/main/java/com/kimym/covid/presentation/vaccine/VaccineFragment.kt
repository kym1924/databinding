package com.kimym.covid.presentation.vaccine

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.kimym.covid.R
import com.kimym.covid.base.BaseFragment
import com.kimym.covid.databinding.FragmentVaccineBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VaccineFragment : BaseFragment<FragmentVaccineBinding>(R.layout.fragment_vaccine) {
    private val viewModel by viewModels<VaccineViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding.rvVaccine) {
            adapter = VaccineAdapter()
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }
    }
}

package com.kimym.covid.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.kimym.covid.R
import com.kimym.covid.databinding.ActivityMainBinding
import com.kimym.covid.presentation.infection.InfectionFragment
import com.kimym.covid.presentation.vaccine.VaccineFragment
import dagger.hilt.android.AndroidEntryPoint
import java.lang.IndexOutOfBoundsException

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setViewPagerAdapter()
        setTabLayoutMediator()
    }

    private fun setViewPagerAdapter() {
        binding.vpMain.adapter = object : FragmentStateAdapter(this@MainActivity) {
            override fun getItemCount(): Int {
                return 2
            }

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> InfectionFragment()
                    1 -> VaccineFragment()
                    else -> throw IndexOutOfBoundsException()
                }
            }
        }
    }

    private fun setTabLayoutMediator() {
        TabLayoutMediator(binding.tabMain, binding.vpMain) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.infection_status)
                1 -> getString(R.string.vaccination_status)
                else -> throw IndexOutOfBoundsException()
            }
        }.attach()
    }
}

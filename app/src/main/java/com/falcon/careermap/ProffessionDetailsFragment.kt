package com.falcon.careermap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.falcon.careermap.adapters.SectionsPagerAdapter
import com.falcon.careermap.adapters.TAB_TITLES
import com.falcon.careermap.databinding.FragmentProffessionDetailsBinding
import com.google.android.material.tabs.TabLayoutMediator


class ProffessionDetailsFragment : Fragment() {
    private var _binding: FragmentProffessionDetailsBinding? = null

    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProffessionDetailsBinding.inflate(inflater, container, false)
        val proffessionDescription = arguments?.getString("Details")
        sharedViewModel.professionDescription = proffessionDescription
//        Toast.makeText(requireContext(), proffessionDescription, Toast.LENGTH_SHORT).show()
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, viewPager) { tab, position ->
            tab.text = context?.getString(TAB_TITLES[position])
        }.attach()

        return binding.root
    }

}
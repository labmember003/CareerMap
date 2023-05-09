package com.falcon.careermap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.falcon.careermap.databinding.FragmentProfessionDescriptionBinding


class ProfessionDescriptionFragment : Fragment() {
    private var _binding: FragmentProfessionDescriptionBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfessionDescriptionBinding.inflate(inflater, container, false)

        binding.tvProffessionDescription.text = sharedViewModel.professionDescription
        return binding.root
    }


}
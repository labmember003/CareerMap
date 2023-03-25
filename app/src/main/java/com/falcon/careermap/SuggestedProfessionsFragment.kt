package com.falcon.careermap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.falcon.careermap.databinding.FragmentFifthBinding
import com.falcon.careermap.databinding.FragmentSuggestedProfessionsBinding

class SuggestedProfessionsFragment : Fragment() {

    private var _binding: FragmentSuggestedProfessionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSuggestedProfessionsBinding.inflate(inflater, container, false)
        return binding.root
    }
}
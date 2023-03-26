package com.falcon.careermap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.falcon.careermap.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun updateValues() {
        // QUESTIONS
        binding.question1Textview.text
        binding.question2Textview.text
        binding.question3Textview.text
        binding.question4Textview.text

        //Q1 ANSWERS
        binding.answer11Radiobutton.text
        binding.answer12Radiobutton.text
        binding.answer13Radiobutton.text

        //Q2 ANSWERS
        binding.answer21Radiobutton.text
        binding.answer22Radiobutton.text
        binding.answer23Radiobutton.text

        //Q3 ANSWERS
        binding.answer31Radiobutton.text
        binding.answer32Radiobutton.text
        binding.answer33Radiobutton.text

    }
}
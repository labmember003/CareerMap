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
        updateValues()
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun updateValues() {
        // QUESTIONS
        binding.question1Textview.text = "Q1: Which of the following fields interests you the most?"
        binding.question2Textview.text = "Q2: Do you enjoy working with people directly or indirectly?"
        binding.question3Textview.text = "Q3: Do you prefer a job that requires more hands-on work or more technical work?"

        //Q1 ANSWERS
        binding.answer11Radiobutton.text= "Healthcare"
        binding.answer12Radiobutton.text= "Technology"
        binding.answer13Radiobutton.text= "Science"

        //Q2 ANSWERS
        binding.answer21Radiobutton.text = "Directly"
        binding.answer22Radiobutton.text = "Indirectly"
        binding.answer23Radiobutton.text = "It does not matter"

        //Q3 ANSWERS
        binding.answer31Radiobutton.text = "Hands-on"
        binding.answer32Radiobutton.text = "Technical"
        binding.answer33Radiobutton.text = "Both"

    }
}
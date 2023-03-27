package com.falcon.careermap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.falcon.careermap.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener{
            findNavController().navigate(R.id.action_SecondFragment_to_fifthFragment)
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
        binding.question1Textview.text = "Q1: Are you good at communicating with others?"
        binding.question2Textview.text = "Q2: Are you detail-oriented?"
        binding.question3Textview.text = "Q3: Are you comfortable working with advanced technology?"

        //Q1 ANSWERS
        binding.answer11Radiobutton.text= "Yes"
        binding.answer12Radiobutton.text= "No"
        binding.answer13Radiobutton.text= "Somewhat"

        //Q2 ANSWERS
        binding.answer21Radiobutton.text = "Yes"
        binding.answer22Radiobutton.text = "No"
        binding.answer23Radiobutton.text = "Somewhat"

        //Q3 ANSWERS
        binding.answer31Radiobutton.text = "Yes"
        binding.answer32Radiobutton.text = "No"
        binding.answer33Radiobutton.text = "Somewhat"

    }
}
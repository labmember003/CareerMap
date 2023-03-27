package com.falcon.careermap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.falcon.careermap.databinding.FragmentFifthBinding

class FifthFragment : Fragment() {
    private var _binding: FragmentFifthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFifthBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener{
            findNavController().navigate(R.id.action_fifthFragment_to_suggestedProfessionsFragment)
        }
        updateValues()
        return binding.root
    }
    private fun updateValues() {
        // QUESTIONS
        binding.question1Textview.text = "Q1: What is the primary focus of your work?"
        binding.question2Textview.text = "Q2: Which of the following is a common procedure in your field?"
        binding.question3Textview.text = "Q3: Which of the following is an important skill for your job?"

        //Q1 ANSWERS
        binding.answer11Radiobutton.text= "Diagnosing and treating dental conditions"
        binding.answer12Radiobutton.text= "Diagnosing and treating hearing and balance disorders"
        binding.answer13Radiobutton.text= "Operating imaging equipment to create diagnostic images"

        //Q2 ANSWERS
        binding.answer21Radiobutton.text= "Filling a cavity"
        binding.answer22Radiobutton.text= "Conducting a hearing test"
        binding.answer23Radiobutton.text= "Performing an X-ray"

        //Q3 ANSWERS
        binding.answer31Radiobutton.text = "Manual dexterity"
        binding.answer32Radiobutton.text = "Good communication skills"
        binding.answer33Radiobutton.text = "Technical expertise in operating imaging equipment"

    }
}
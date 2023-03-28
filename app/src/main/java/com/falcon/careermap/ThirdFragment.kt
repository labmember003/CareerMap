package com.falcon.careermap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.falcon.careermap.adapters.RcvQuestionnaire
import com.falcon.careermap.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener{
            findNavController().navigate(R.id.action_thirdFragment_to_fifthFragment)
        }
        val questionList = listOf("Q1: Which of the following fields interests you the most?",
            "Q2: Do you enjoy working with people directly or indirectly?",
            "Q3: Do you prefer a job that requires more hands-on work or more technical work?"
        )
        val question1Answers = listOf("Healthcare", "Technology", "Science")
        val question2Answers = listOf("Directly", "Indirectly", "It does not matter")
        val question3Answers = listOf("Hands-on", "Technical", "Both")
        val answerList = listOf(question1Answers, question2Answers, question3Answers)
        binding.questionRCV.adapter = RcvQuestionnaire(questionList, answerList)
        binding.questionRCV.layoutManager = LinearLayoutManager(requireContext())
        return binding.root

    }

}
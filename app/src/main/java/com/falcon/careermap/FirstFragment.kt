package com.falcon.careermap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.falcon.careermap.adapters.RcvQuestionnaire
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
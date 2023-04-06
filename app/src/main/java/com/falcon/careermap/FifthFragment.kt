package com.falcon.careermap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.falcon.careermap.adapters.RcvQuestionnaire
import com.falcon.careermap.databinding.FragmentFifthBinding

class FifthFragment : Fragment() {
    private var _binding: FragmentFifthBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFifthBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener{
            findNavController().navigate(R.id.action_fifthFragment_to_suggestedProfessionsFragment)
        }
        val questionList = listOf("Q1: Which of the following fields interests you the most?",
            "Q2: Do you enjoy working with people directly or indirectly?",
            "Q3: Do you prefer a job that requires more hands-on work or more technical work?"
        )
        val question1Answers = listOf("Healthcare", "Technology", "Science")
        val question2Answers = listOf("Directly", "Indirectly", "It does not matter")
        val question3Answers = listOf("Hands-on", "Technical", "Both")
//        val answerList = listOf(question1Answers, question2Answers, question3Answers)
        val answerList = arguments?.getSerializable("answerList") as? ArrayList<ArrayList<String>>
        binding.questionRCV.adapter = answerList?.let {
            RcvQuestionnaire(ArrayList(listOf("")),
                it, requireContext().applicationContext, ::onItemSelect)
        }
        binding.questionRCV.layoutManager = LinearLayoutManager(requireContext())
        return binding.root

    }
    private fun onItemSelect(questionNumber: Int, answerNumber: Int, isSelected: Boolean) {
        Toast.makeText(requireContext(), "$questionNumber&$answerNumber", Toast.LENGTH_SHORT).show()
    }
}
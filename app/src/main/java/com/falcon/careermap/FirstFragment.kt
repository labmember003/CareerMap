package com.falcon.careermap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
//        val questionList = ArrayList(listOf("Q1: Which of the following fields interests you the most?",
//            "Q2: Do you enjoy working with people directly or indirectly?",
//            "Q3: Do you prefer a job that requires more hands-on work or more technical work?"
//        ))
        val questionList = arguments?.getStringArrayList("questionList")
        val answerList = arguments?.getSerializable("answerList") as? ArrayList<ArrayList<String>>
//        val question1Answers = listOf("Healthcare", "Technology", "Science")
//        val question2Answers = listOf("Directly", "Indirectly", "It does not matter")
//        val question3Answers = listOf("Hands-on", "Technical", "Both")
//        val answerListt = listOf(question1Answers, question2Answers, question3Answers)
        binding.questionRCV.adapter = answerList?.let {
            RcvQuestionnaire(questionList?:ArrayList(listOf("")),
                it, requireContext().applicationContext, ::onItemSelect)
        }
        binding.questionRCV.layoutManager = LinearLayoutManager(requireContext())
        return binding.root

    }

    private fun onItemSelect(questionNumber: Int, answerNumber: Int, isSelected: Boolean) {
        Toast.makeText(requireContext(), "$questionNumber&$answerNumber", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.falcon.careermap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.falcon.careermap.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        val questionList = ArrayList(listOf("Q1: Which of the following fields interests you the most?",
            "Q2: Do you enjoy working with people directly or indirectly?",
            "Q3: Do you prefer a job that requires more hands-on work or more technical work?"
        ))
        val answerList = ArrayList<ArrayList<String>>()
        answerList.add(ArrayList(listOf("Healthcare", "Technology", "Science")))
        answerList.add(ArrayList(listOf("Directly", "Indirectly", "It does not matter")))
        answerList.add(ArrayList(listOf("Hands-on", "Technical", "Both")))
//        val question1Answers = listOf("Healthcare", "Technology", "Science")
//        val question2Answers = listOf("Directly", "Indirectly", "It does not matter")
//        val question3Answers = listOf("Hands-on", "Technical", "Both")
//        val answerList = listOf(question1Answers, question2Answers, question3Answers)
        val bundle = Bundle()
        bundle.putStringArrayList("questionList", questionList)
        bundle.putSerializable("answerList", answerList)
        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_FirstFragment, bundle)
        }
        return binding.root
    }


}
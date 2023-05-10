package com.falcon.careermap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.falcon.careermap.databinding.FragmentLoginBinding
import com.falcon.careermap.databinding.FragmentSignUpBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
//        findNavController().navigate(R.id.action_loginFragment_to_analysisFragment)
        val questionList = arrayListOf("Q1: Which of the following fields interests you the most?",
            "Q2: Do you enjoy working with people directly or indirectly?",
            "Q3: Do you prefer a job that requires more hands-on work or more technical work?",
//            "Q3: Do you prefer a job that requires more hands-on work or more technical work?",
//            "Q3: Do you prefer a job that requires more hands-on work or more technical work?",
//            "Q3: Do you prefer a job that requires more hands-on work or more technical work?",
//            "Q3: Do you prefer a job that requires more hands-on work or more technical work?",
//            "Q3: Do you prefer a job that requires more hands-on work or more technical work?",
//            "Q3: Do you prefer a job that requires more hands-on work or more technical work?",
//            "Q3: Do you prefer a job that requires more hands-on work or more technical work?"
        )
        val answerList = ArrayList<ArrayList<String>>()
        answerList.add(ArrayList(listOf("Healthcare", "Technology", "Science")))
        answerList.add(ArrayList(listOf("Directly", "Indirectly", "It does not matter")))
        answerList.add(ArrayList(listOf("Hands-on", "Technical", "Both")))
//        answerList.add(ArrayList(listOf("Hands-on", "Technical", "Both")))
//        answerList.add(ArrayList(listOf("Hands-on", "Technical", "Both")))
//        answerList.add(ArrayList(listOf("Hands-on", "Technical", "Both")))
//        answerList.add(ArrayList(listOf("Hands-on", "Technical", "Both")))
//        answerList.add(ArrayList(listOf("Hands-on", "Technical", "Both")))
//        answerList.add(ArrayList(listOf("Hands-on", "Technical", "Both")))
//        answerList.add(ArrayList(listOf("Hands-on", "Technical", "Both")))
        val bundle = Bundle()
        bundle.putStringArrayList("questionList", questionList)
        bundle.putSerializable("answerList", answerList)
        bundle.putInt("instanceNumber", 1)
        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_FirstFragment, bundle)
        }
        return binding.root
    }
}
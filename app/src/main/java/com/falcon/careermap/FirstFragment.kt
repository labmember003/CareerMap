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
import com.falcon.careermap.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    companion object {
        fun newInstance(arg1: ArrayList<String>?, arg2: ArrayList<ArrayList<String>>, arg3: Int): FirstFragment {
            val fragment = FirstFragment()
            val args = Bundle().apply {
                putStringArrayList("questionList", arg1)
                putSerializable("answerList", arg2)
                putInt("instanceNumber", arg3)
            }
            fragment.arguments = args
            return fragment
        }
    }
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        var questionList = arguments?.getStringArrayList("questionList")
        var answerList = arguments?.getSerializable("answerList") as? ArrayList<ArrayList<String>>
        val instanceNumber = arguments?.getInt("instanceNumber")
        when (instanceNumber) {
            1 -> {
                questionList = arrayListOf("Q1 What is your preferred work style?", "Q2 Do you enjoy problem-solving activities?", "Q3 How do you handle pressure?")
                val answerList1 = arrayListOf("Working Alone", "Working in a Group", "Both")
                val answerList2 = arrayListOf("Yes", "No", "Sometimes")
                val answerList3 = arrayListOf("I work well under pressure", "I get anxious under pressure", "I do not like working under pressure")
                answerList = arrayListOf(answerList1, answerList2, answerList3)
            }
            2 -> {
                questionList = arrayListOf("Q4 Are you comfortable with public speaking?", "Q5 Do you enjoy working with numbers?", "Q6 How do you prefer to learn new things?")
                val answerList1 = arrayListOf("Yes", "No", "Sometimes")
                val answerList2 = arrayListOf("Yes", "No", "Sometimes")
                val answerList3 = arrayListOf("Through hands-on experience", "Through reading and research", "Through group discussions")
                answerList = arrayListOf(answerList1, answerList2, answerList3)
            }
            3 -> {
                questionList = arrayListOf("Q7 Are you interested in creative activities such as writing, art or music?", "Q8 What is your preferred work environment?", "Q9 How do you like to work on projects?")
                val answerList1 = arrayListOf("Yes", "No", "Sometimes")
                val answerList2 = arrayListOf("Outdoors", "Indoors", "Both")
                val answerList3 = arrayListOf("Independently", "Collaboratively", "Both")
                answerList = arrayListOf(answerList1, answerList2, answerList3)
            }
        }
        binding.questionRCV.adapter = answerList?.let {
            RcvQuestionnaire(questionList?:ArrayList(listOf("")),
                it, requireContext().applicationContext, ::onItemSelect)
        }
        binding.questionRCV.layoutManager = LinearLayoutManager(requireContext())
        binding.submitButton.setOnClickListener{
            if (instanceNumber == 3) {
                findNavController().navigate(R.id.action_FirstFragment_to_suggestedProfessionsFragment)
            } else {
                val newFragment = answerList?.let { it1 ->
                    FirstFragment.newInstance(questionList,
                        it1, instanceNumber?.plus(1) ?: 0
                    )
                }
                val fragmentManager = parentFragmentManager
                val transaction = fragmentManager.beginTransaction()
                if (newFragment != null) {
                    transaction.replace(R.id.nav_host_fragment_content_main, newFragment)
                }
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
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
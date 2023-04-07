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
        val questionList = arguments?.getStringArrayList("questionList")
        val answerList = arguments?.getSerializable("answerList") as? ArrayList<ArrayList<String>>
        val instanceNumber = arguments?.getInt("instanceNumber")
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
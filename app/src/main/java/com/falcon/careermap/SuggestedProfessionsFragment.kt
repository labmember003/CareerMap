package com.falcon.careermap

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.falcon.careermap.databinding.FragmentFifthBinding
import com.falcon.careermap.databinding.FragmentSuggestedProfessionsBinding
import java.io.File

class SuggestedProfessionsFragment : Fragment() {

    private var _binding: FragmentSuggestedProfessionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSuggestedProfessionsBinding.inflate(inflater, container, false)
        val proffessionList: List<String> = listOf("Dentist", "Audiologist", "Radiologic Technologist")
        val proffessionDescriptorList : List<String> = listOf("Diagnose and treat dental problems and diseases.", "Diagnose and treat hearing and balance disorders.", "Perform diagnostic imaging tests and procedures, such as x-rays and CT scans.")
        val proffessionLongDescriptorList : List<String> = listOf("meow", "meow", "meow")
        binding.rcvProffesionList.adapter = rcvProffesionListAdapter(proffessionList, proffessionDescriptorList, proffessionLongDescriptorList,  ::onContentClick, ::searchProfession)
        binding.rcvProffesionList.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }
    private fun onContentClick(proffessionDescription: String) {
        val b = Bundle()
        b.putString("Details", proffessionDescription)
        findNavController().navigate(R.id.action_suggestedProfessionsFragment_to_proffessionDetailsFragment, b)
    }
    private fun searchProfession(proffessionName: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com/search?q=$proffessionName")
        startActivity(intent)
    }
}
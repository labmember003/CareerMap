package com.falcon.careermap

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val proffessionList: List<String> = listOf("Doctor", "Doctor", "Doctor")
        binding.rcvProffesionList.adapter = rcvProffesionListAdapter(proffessionList, ::onContentClick, ::searchProfession)
        return binding.root
    }
    private fun onContentClick(proffessionName: String) {

    }
    private fun searchProfession(proffessionName: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com/search?q=$proffessionName")
        startActivity(intent)
    }
}
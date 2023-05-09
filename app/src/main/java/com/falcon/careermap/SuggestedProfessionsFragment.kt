package com.falcon.careermap

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.falcon.careermap.databinding.FragmentSuggestedProfessionsBinding

class SuggestedProfessionsFragment : Fragment() {

    private var _binding: FragmentSuggestedProfessionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSuggestedProfessionsBinding.inflate(inflater, container, false)
        val proffessionList: List<String> = listOf("Dentist", "Audiologist", "Radiologic Technologist")
        val proffessionDescriptorList : List<String> = listOf("Diagnose and treat dental problems and diseases.", "Diagnose and treat hearing and balance disorders.", "Perform diagnostic imaging tests and procedures, such as x-rays and CT scans.")
        val proffessionLongDescriptorList : List<String> = listOf("A dentist is a licensed healthcare professional who specializes in the diagnosis, treatment, and prevention of oral diseases and conditions. They are responsible for maintaining the oral health of their patients, including teeth, gums, and other tissues in the mouth.\n" +
                "\n" +
                "Dentists perform a range of procedures, including routine cleanings, fillings, extractions, and root canals, as well as more complex treatments such as dental implants and orthodontics. They also educate their patients on proper oral hygiene and preventative measures to maintain good oral health.\n" +
                "\n" +
                "Dentists work in a variety of settings, including private practices, hospitals, and community clinics. They must complete a dental degree program and pass licensing exams in order to practice. Dentists also need to stay up to date with the latest techniques and technologies in their field through ongoing education and professional development.",


            "An audiologist is a healthcare professional who specializes in the diagnosis, treatment, and management of hearing and balance disorders. They work with patients of all ages to assess their hearing and balance abilities and provide appropriate interventions.\n" +
                    "\n" +
                    "Audiologists perform a variety of tests to evaluate hearing and balance, including pure-tone audiometry, speech audiometry, and balance assessments. They also fit and dispense hearing aids, cochlear implants, and other assistive listening devices. Additionally, they provide counseling and education to patients and their families on communication strategies and coping skills related to hearing loss.\n" +
                    "\n" +
                    "Audiologists work in a variety of settings, including hospitals, clinics, schools, and private practices. They must complete a master's or doctoral degree in audiology and pass licensing exams in order to practice. They also participate in ongoing education and professional development to stay up to date with advances in their field.",


            "A radiologic technologist, also known as a radiographer, is a healthcare professional who specializes in performing diagnostic imaging procedures using X-rays, CT scans, MRI, and other imaging technologies. They work closely with radiologists and other physicians to help diagnose and treat medical conditions.\n" +
                    "\n" +
                    "Radiologic technologists operate sophisticated imaging equipment to capture images of various parts of the body. They prepare patients for procedures, position them correctly, and ensure that the equipment is calibrated properly. They also monitor patient safety during the procedures and keep detailed records of the images taken.\n" +
                    "\n" +
                    "Radiologic technologists work in a variety of healthcare settings, including hospitals, clinics, and imaging centers. They must complete a degree program in radiography and pass certification exams in order to practice. They also participate in ongoing education and professional development to stay up to date with advances in their field.")
        binding.rcvProffesionList.adapter = rcvProffesionListAdapter(proffessionList, proffessionDescriptorList, proffessionLongDescriptorList,  ::onContentClick, ::searchProfession)
        binding.rcvProffesionList.layoutManager = LinearLayoutManager(requireContext())
        binding.detailTextView.setOnClickListener {
            findNavController().navigate(R.id.action_suggestedProfessionsFragment_to_analysisFragment)
        }
        return binding.root
    }
    private fun onContentClick(proffessionDescription: String) {
        val proffessionDescriptionBundle = Bundle()
        proffessionDescriptionBundle.putString("Details", proffessionDescription)
        findNavController().navigate(R.id.action_suggestedProfessionsFragment_to_proffessionDetailsFragment, proffessionDescriptionBundle)
    }
    private fun searchProfession(proffessionName: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com/search?q=$proffessionName")
        startActivity(intent)
    }
}
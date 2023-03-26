package com.falcon.careermap

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.falcon.careermap.adapters.RcvContactProffesionalAdapters
import com.falcon.careermap.databinding.FragmentNetworkBinding

class NetworkFragment : Fragment() {
    private var _binding: FragmentNetworkBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNetworkBinding.inflate(inflater, container, false)

        val professionalList: List<String> = listOf("Dr.Priya", "Dr Rajesh", "Dr Sanjay")
        val proffessionalPhoneNumberList : List<String> = listOf("+91 8800136151", "+91 8800136151", "+91 8800136151")
        val proffessionalMailIdList: List<String> = listOf("avishishtgupta@gmail.com", "avishishtgupta@gmail.com", "avishishtgupta@gmail.com")
        binding.professionalContactList.adapter = RcvContactProffesionalAdapters(professionalList, proffessionalMailIdList, proffessionalPhoneNumberList,  ::onMailButtonClick, ::onSmsButtonClick)
        binding.professionalContactList.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }
    private fun onMailButtonClick(mailId: String) {
        composeEmail("Queries Regarding Your Profession", mailId)
    }
    fun composeEmail(subject: String, mailId: String) {
        val a = arrayOf(mailId)
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, a)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(requireContext(), "No Mail App Found", Toast.LENGTH_SHORT).show()
        }
    }
    private fun onSmsButtonClick(phoneNumber: String) {
        val smsUri = Uri.parse("smsto:$phoneNumber")
        val smsIntent = Intent(Intent.ACTION_SENDTO, smsUri)
        smsIntent.putExtra("sms_body", "Hello, Avishisht This Side")
        startActivity(smsIntent)
    }


}
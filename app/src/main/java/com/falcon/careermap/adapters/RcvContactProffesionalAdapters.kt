package com.falcon.careermap.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.falcon.careermap.R

class RcvContactProffesionalAdapters(private val professionalList: List<String>, private val proffessionalMailIdList: List<String>,
                                     private val proffessionalPhoneNumberList: List<String>,
                                     private val onMailButtonClick : (String) -> Unit,
                                     private val onSmsButtonClick : (String) -> Unit) : RecyclerView.Adapter<RcvContactProffesionalAdapters.ProfessionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.professional_contact, parent, false)
        return ProfessionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfessionViewHolder, position: Int) {
        holder.professionalName.text = professionalList[position]
        holder.mailButton.setOnClickListener {
            onMailButtonClick(proffessionalMailIdList[position])
        }
        holder.smsButton.setOnClickListener {
            onSmsButtonClick(proffessionalPhoneNumberList[position])
        }
    }
    override fun getItemCount(): Int {
        return professionalList.size
    }
    class ProfessionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val professionalName: TextView = itemView.findViewById(R.id.professionalNames)
        val mailButton: ImageView = itemView.findViewById(R.id.mailButton)
        val smsButton: ImageView = itemView.findViewById(R.id.smsButton)
    }
}
package com.falcon.careermap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class rcvProffesionListAdapter(private val professionList: List<String>, private val proffessionDescriptorList: List<String>,
                               private val proffessionLongDescriptorList: List<String>,
                               private val onContentClick : (String) -> Unit,
                               private val searchProfession : (String) -> Unit) : RecyclerView.Adapter<rcvProffesionListAdapter.ProfessionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.profession, parent, false)
        return ProfessionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfessionViewHolder, position: Int) {
        holder.professionName.text = professionList[position]
        holder.additionalInfoText.text = proffessionDescriptorList[position]
        holder.professionName.setOnClickListener {
            onContentClick(proffessionLongDescriptorList[position])
        }
        holder.previewImage.setOnClickListener {
            onContentClick(proffessionLongDescriptorList[position])
        }
        holder.searchButton.setOnClickListener {
            searchProfession(professionList[position])
        }
        holder.infoButton.setOnClickListener {
            if (holder.additionalInfoText.isVisible) {
                holder.additionalInfoText.visibility = View.GONE
            } else {
                holder.additionalInfoText.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return professionList.size
    }
    class ProfessionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val professionName: TextView = itemView.findViewById(R.id.professionName)
        val previewImage: ImageView = itemView.findViewById(R.id.previewImage)
        val searchButton: ImageView = itemView.findViewById(R.id.searchButton)
        val infoButton: ImageView = itemView.findViewById(R.id.infoButton)
        val additionalInfoText: TextView = itemView.findViewById(R.id.additionalInfo)
    }
}
package com.falcon.careermap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rcvProffesionListAdapter(private val professionList: List<String>, private val onContentClick : (String) -> Unit,
                               private val searchProfession : (String) -> Unit) : RecyclerView.Adapter<rcvProffesionListAdapter.ProfessionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.profession, parent, false)
        return ProfessionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfessionViewHolder, position: Int) {
        holder.convertedPDF.text = professionList[position]
        holder.convertedPDF.setOnClickListener {
            onContentClick(professionList[position])
        }
        holder.previewImage.setOnClickListener {
            onContentClick(professionList[position])
        }
        holder.searchButton.setOnClickListener {
            searchProfession(professionList[position])
        }

    }

    override fun getItemCount(): Int {
        return professionList.size
    }
    class ProfessionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val convertedPDF: TextView = itemView.findViewById(R.id.professionName)
        val previewImage: ImageView = itemView.findViewById(R.id.previewImage)
        val searchButton: ImageView = itemView.findViewById(R.id.searchButton)
    }
}
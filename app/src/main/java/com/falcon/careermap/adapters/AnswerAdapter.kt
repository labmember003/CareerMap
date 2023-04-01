package com.falcon.careermap.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.falcon.careermap.R


class AnswerAdapter(private val answerList: List<String>) : RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.answer_single, parent, false)
        return AnswerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.answerText.text = answerList[position]
    }

    override fun getItemCount(): Int {
        return answerList.size
    }
    class AnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val answerText: TextView = itemView.findViewById(R.id.answer_single_MRB)
    }
}

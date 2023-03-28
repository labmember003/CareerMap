package com.falcon.careermap.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.falcon.careermap.R
import com.google.android.material.radiobutton.MaterialRadioButton

class RcvQuestionnaire(private val questionList: List<String>, private val answerList: List<List<String>>,
                       /*
                       abhi ke liye suppose har qustion le 3 answers he honge,
                       not less than 3, not more than 3
                        */
                       ) : RecyclerView.Adapter<RcvQuestionnaire.QuestionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.question, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.question.text = questionList[position]
        holder.answer1.text = answerList[position][0]
        holder.answer2.text = answerList[position][1]
        holder.answer3.text = answerList[position][2]
    }
    override fun getItemCount(): Int {
        return questionList.size
    }
    class QuestionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val question: TextView = itemView.findViewById(R.id.question_textview)
        val answer1: MaterialRadioButton = itemView.findViewById(R.id.answer_1_radiobutton)
        val answer2: MaterialRadioButton = itemView.findViewById(R.id.answer_2_radiobutton)
        val answer3: MaterialRadioButton = itemView.findViewById(R.id.answer_3_radiobutton)
    }
}
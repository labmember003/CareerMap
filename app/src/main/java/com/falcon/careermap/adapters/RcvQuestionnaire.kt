package com.falcon.careermap.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.falcon.careermap.R

class RcvQuestionnaire(private val questionList: List<String>, private val answerList: List<List<String>>, private val context : Context,
                       ) : RecyclerView.Adapter<RcvQuestionnaire.QuestionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.question_answer, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.question.text = questionList[position]
        val listOfAnswer = answerList[position]
        holder.answerList.adapter = AnswerAdapter(listOfAnswer)
        holder.answerList.layoutManager = LinearLayoutManager(context)
    }
    override fun getItemCount(): Int {
        return questionList.size
    }
    class QuestionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val question: TextView = itemView.findViewById(R.id.question_textview)
        val answerList: RecyclerView = itemView.findViewById(R.id.answerRecyclerView)
    }
}
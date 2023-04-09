package com.falcon.careermap.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.falcon.careermap.R
import com.google.android.material.radiobutton.MaterialRadioButton

class RcvQuestionnaire(private val questionList: ArrayList<String>, private val answerList: ArrayList<ArrayList<String>>, private val context : Context,
                       private val onItemSelect : (Int, Int, Boolean) -> Unit
                       ) : RecyclerView.Adapter<RcvQuestionnaire.QuestionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.question_answer, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.question.text = questionList[position]
        holder.contentLL.removeAllViews()
        val listOfAnswer = answerList[position]
        for (i in 1..listOfAnswer.size) {
            val answerView = LayoutInflater.from(holder.itemView.context).inflate(R.layout.answer_single, holder.itemView as ViewGroup, false)
            answerView.findViewById<MaterialRadioButton>(R.id.answer_single_MRB).text = listOfAnswer[i - 1]
//             SET ANSWER AND SAVE IT AND RENDER IT AGGAIN IN ONBINDVIEWHOLDER (user niche jaake upar aata hai tho answers gayab ho jaate hai)
//            val parentLayout = holder.holderLayout
            holder.contentLL.addView(answerView)
        }
    }
    private fun onItemSelected(questionNumber: Int, answerIndex: Int, isSelected: Boolean) {
        onItemSelect(questionNumber, answerIndex, isSelected)
    }
    override fun getItemCount(): Int {
        return questionList.size
    }
    class QuestionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val question: TextView = itemView.findViewById(R.id.question_textview)
        val holderLayout: LinearLayout = itemView.findViewById(R.id.question_LL)
        val contentLL: LinearLayout = itemView.findViewById(R.id.contentLL)
    }
}
package com.falcon.careermap.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.falcon.careermap.R
import com.google.android.material.radiobutton.MaterialRadioButton

class RcvQuestionnaire(private val questionList: List<String>, private val answerList: List<List<String>>, private val context : Context,
                       /*
                       abhi ke liye suppose har qustion le 3 answers he honge,
                       not less than 3, not more than 3
                        */
                       ) : RecyclerView.Adapter<RcvQuestionnaire.QuestionViewHolder>() {
    private var view = View(context)
    private var answerLayout = View(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        view = inflater.inflate(R.layout.question, parent, false)
        answerLayout = inflater.inflate(R.layout.answer_layout, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val linearLayout = view.findViewById<LinearLayout>(R.id.question_LL)

        // Create a new TextView and set its properties
//        val textView = TextView(context)
//        textView.text = "Hello World!"
//        textView.setTextColor(Color.BLACK)
//        textView.textSize = 35F

        answerLayout.findViewById<MaterialRadioButton>(R.id.answer_1_radiobutton).text = "meow"
        linearLayout.addView(answerLayout)

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
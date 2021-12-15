package com.example.newsmart.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsmart.R
import com.example.newsmart.model.Question

typealias OnQuestionClickListener = (Question) -> Unit

class QuestionAdapter(
    private val questions : List<Question>,
    private val listener : OnQuestionClickListener
): RecyclerView.Adapter<QuestionAdapter.QuestionVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return QuestionVH(
            layoutInflater.inflate(R.layout.item_phone,parent,false),
            listener
        )
    }

    override fun onBindViewHolder(holder: QuestionVH, position: Int) = holder.bind(questions[position])

    override fun getItemCount(): Int = questions.size

    class QuestionVH(
        view: View,
        listener: OnQuestionClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val ivAvatar = view.findViewById<ImageView>(R.id.ivAvatar)
        private val tvName = view.findViewById<TextView>(R.id.tvName)
        private val tvDate = view.findViewById<TextView>(R.id.tvDate)
        private val tvDescription = view.findViewById<TextView>(R.id.tvDescr)

        private lateinit var question : Question

        init {
            view.setOnClickListener { listener(question)}
        }

        @SuppressLint("SetTextI18n")
        fun bind (question: Question){
            this.question = question
            tvName.text = question.user.name+question.user.lastName
            tvDate.text = question.date
            tvDescription.text = question.question
            ivAvatar.setImageResource(question.user.coverResId)
        }
    }
}
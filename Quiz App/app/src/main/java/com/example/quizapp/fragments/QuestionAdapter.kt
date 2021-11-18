package com.example.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.model.Question


class QuestionAdapter (private val list: MutableList<Question>,
                       private val listener: QuestionListFragment
) :  RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    interface OnItemClickListener{
        fun details_onClick(position: Int)
        fun remove_onClick(position: Int)

    }





    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val question1: TextView
        val correct_answer: TextView
        val details_button: Button
        val delete_button: Button


        init {
            // Define click listener for the ViewHolder's View.

            question1 = view.findViewById(R.id.question1)
            correct_answer = view.findViewById(R.id.corect_answer)
            details_button = view.findViewById(R.id.detalis_button)
            delete_button = view.findViewById(R.id.delete_button)
            details_button.setOnClickListener(this)
            delete_button.setOnClickListener(View.OnClickListener {
                fun onClick(p0: View?) {

                    val currentPosition = adapterPosition
                    if (currentPosition != RecyclerView.NO_POSITION) {
                        listener.remove_onClick(currentPosition)

                    }
                }
            })


        }
        override fun onClick(p0: View?) {
            val currentPosition = adapterPosition
//            Log.d("xxx", "AdapterPosition: $currentPosition")
            listener.detalis_onClick(currentPosition)




        }




    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_layout, viewGroup, false)

        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curentItem =list[position]
        holder.question1.text=curentItem.text
        holder.correct_answer.text = curentItem.answers.get(0)




    }
    override fun getItemCount()=list.size



}
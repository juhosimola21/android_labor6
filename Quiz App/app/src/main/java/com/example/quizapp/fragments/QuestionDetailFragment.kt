package com.example.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.quizapp.R
import com.example.quizapp.model.MainViewModel
import com.example.quizapp.model.Question


class QuestionDetailFragment : Fragment() {
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_question_detail, container, false)
        //viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)


        val question_detali_text: TextView = view.findViewById(R.id.question_detail_text)
        val detail_answer1 : TextView = view.findViewById(R.id.detail_answer1)
        val detail_answer2 : TextView = view.findViewById(R.id.detail_answer2)
        val detail_answer3 : TextView = view.findViewById(R.id.detail_answer3)
        val detail_answer4 : TextView = view.findViewById(R.id.detail_answer4)
        val item: Question = viewModel.getItem()


        question_detali_text.text=item.text
        detail_answer1.text = item.answers.get(0)
        detail_answer2.text = item.answers.get(1)
        detail_answer3.text = item.answers.get(2)
        detail_answer4.text = item.answers.get(3)


        return view
    }
}
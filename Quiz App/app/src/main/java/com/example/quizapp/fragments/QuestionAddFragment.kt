package com.example.quizapp.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.model.*


class QuestionAddFragment : Fragment() {
    private lateinit var add_question_question: EditText
    private lateinit var textView5: TextView
    private lateinit var add_question_answer1 : EditText
    private lateinit var add_question_answer2 : EditText
    private lateinit var add_question_answer3 : EditText
    private lateinit var add_question_answer4 : EditText
    private lateinit var add_question_button: Button
    private lateinit var add_correct_answer : EditText


    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_question_add, container, false)
        //viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::java)

        view?.apply {
            initialize_question_add_fragment(this)
            registerListener_question_add_fragment()
        }
        return view;
    }

    private fun registerListener_question_add_fragment() {


        add_question_answer4.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                add_question_button.isEnabled=true
                //inicializalom s bealitom a kezdeti erteket a 0 at

                add_question_button.setOnClickListener {


                      viewModel.addItem(
                          Question(add_question_question.text.toString(),
                              listOf(add_question_answer1.text.toString(),
                              add_question_answer2.text.toString(),
                              add_question_answer3.text.toString(),
                              add_question_answer4.text.toString()),
                              add_correct_answer.text.toString()

                    )
                    )
                    findNavController().navigate(R.id.action_questionListFragment_to_questionDetailFragment)


                }
            }

        })
    }


    private fun initialize_question_add_fragment(view: View) {
        add_question_question = view.findViewById(R.id.add_question_question)
        textView5 = view.findViewById(R.id.textView5)
        add_question_answer1 = view.findViewById(R.id.add_question_answer1)
        add_question_answer2 = view.findViewById(R.id.add_question_answer2)
        add_question_answer3 = view.findViewById(R.id.add_question_answer3)
        add_question_answer4 = view.findViewById(R.id.add_question_answer4)
        add_question_button = view.findViewById(R.id.add_question_button)
        add_correct_answer = view.findViewById(R.id.add_correct_answer)
    }
}



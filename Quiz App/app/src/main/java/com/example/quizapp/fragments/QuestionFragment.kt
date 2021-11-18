package com.example.quizapp.fragments

import android.content.Context
import com.example.quizapp.model.Question
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentQuestionBinding
import com.example.quizapp.model.correctAnswers
import com.example.quizapp.model.questions
import androidx.activity.OnBackPressedCallback


import android.app.AlertDialog

import android.content.DialogInterface
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


class QuestionFragment : Fragment() {

    lateinit var binding: FragmentQuestionBinding
    private  var numberOfQuestion:Int = 0
    lateinit var currentQuestion: Question
    private val numberOfQuestions = 10


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)

        randomizeQuestions()
        binding.navigationButton.setOnClickListener {
            if ( numberOfQuestion < numberOfQuestions) {
                processAnswer(it)
                setNextQusetion()
                if(numberOfQuestion == numberOfQuestions){
                    binding.navigationButton.text = "SUBMIT";
                }
            } else {
                if ( numberOfQuestion == numberOfQuestions) {
                    processAnswer(it)
                    it.findNavController().navigate(R.id.action_questionFragment_to_quizEndFragment)

                }
            }
        }

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val alertDialog: AlertDialog? = activity?.let {
                    val builder = AlertDialog.Builder(it)
                    builder.setTitle("EXIT")
                    builder.setMessage("Are you sure you want to exit?")
                    builder.apply {
                        setPositiveButton("Yes",
                            DialogInterface.OnClickListener { dialog, id ->
                                dialog.cancel()
                                findNavController().navigate(R.id.action_questionFragment_to_quizEndFragment)
                            })
                        setNegativeButton("No",
                            DialogInterface.OnClickListener { dialog, id ->
                                dialog.cancel()

                            })
                    }
                    builder.show()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)

        return binding.root
    }

    private fun showQuestion() {
        numberOfQuestion++
        val index = numberOfQuestion
        val questionTextStr = "$index. " + currentQuestion.text
        binding.questionView.text = questionTextStr
        binding.firstAnswer.text = currentQuestion.answers[0]
        binding.secondAnswer.text = currentQuestion.answers[1]
        binding.thirdAnswer.text = currentQuestion.answers[2]
        binding.fourthAnswer.text = currentQuestion.answers[3]

        binding.radioGroup.clearCheck()
    }

    private fun setNextQusetion()
    {
        questions[numberOfQuestion].answers.shuffled()
        currentQuestion = questions[numberOfQuestion]
        showQuestion()
    }
    private fun randomizeQuestions() {
        questions.shuffle()
        setNextQusetion()

    }

    private fun processAnswer(it: View?) {
        val selectedElement = binding.radioGroup.checkedRadioButtonId
        if (selectedElement == -1) {
            Toast.makeText(this.activity, "No answer given", Toast.LENGTH_SHORT).show()
        }
        var indexOfSelectedAnswer = 0
        when (selectedElement) {
            R.id.firstAnswer -> indexOfSelectedAnswer = 0
            R.id.secondAnswer -> indexOfSelectedAnswer = 1
            R.id.thirdAnswer -> indexOfSelectedAnswer = 2
            R.id.fourthAnswer -> indexOfSelectedAnswer = 3
        }
        if(currentQuestion.answers[indexOfSelectedAnswer] == currentQuestion.correctAnswer){
            ++correctAnswers
        }
    }


}
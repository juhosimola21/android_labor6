package com.example.quizapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentQuizEndBinding
import com.example.quizapp.model.correctAnswers
import com.example.quizapp.ui_user_interface.SharedViewModel

class QuizEndFragment : Fragment() {

    private val model: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentQuizEndBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz_end, container, false)

        binding.again.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_quizEndFragment_to_quizStartFragment)
        }
        val result = "$correctAnswers /10 points"
        binding.resultView.text = result

        model.selected.observe(viewLifecycleOwner,  { item ->
            result
        })

        return binding.root
    }
}
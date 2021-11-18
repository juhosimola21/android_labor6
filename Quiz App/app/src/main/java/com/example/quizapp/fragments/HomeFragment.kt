package com.example.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R


class HomeFragment : Fragment() {
    private lateinit var welcome : TextView
    private lateinit var skills: Button
    private lateinit var read_questions: Button
    private lateinit var create_questions: Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_home, container, false)
        view?.apply {
            //inicializalom az elemleket
            initializeViewElements(this) //inicializalas a userName,startButton,chooseButton

            registerListener() //startButton es chooseButton raklikkeles ->mi kell h totenjen


        }
        return view



    }

    private fun registerListener() {
        skills.setOnClickListener {
            findNavController().navigate(R.id.quizStartFragment)
        }
        read_questions.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_questionListFragment)
        }
        create_questions.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_questionAddFragment2)
        }



    }

    private fun initializeViewElements(view: View) {
        welcome = view.findViewById(R.id.welcome)
        skills= view.findViewById(R.id.skills)
        read_questions=view.findViewById(R.id.read_questions)
        create_questions=view.findViewById(R.id.create_questions)

    }
}
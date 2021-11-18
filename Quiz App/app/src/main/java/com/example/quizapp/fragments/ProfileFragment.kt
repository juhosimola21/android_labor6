package com.example.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.quizapp.R
import com.example.quizapp.model.correctAnswers

class ProfileFragment : Fragment() {
    private lateinit var rang_kep : ImageView
    private lateinit var player: TextView
    private lateinit var game_username: TextView
    private lateinit var points: TextView
    private lateinit var user_point: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        view?.apply {
            player = view.findViewById(R.id.player)
            game_username = view.findViewById(R.id.game_username)
            points = view.findViewById(R.id.points)
            user_point = view.findViewById(R.id.user_point)

        }

        game_username.text= game_name
        user_point.text= correctAnswers.toString()

        return view
    }
}
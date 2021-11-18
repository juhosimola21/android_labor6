package com.example.quizapp.model

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizapp.R

class MainViewModel : Fragment() {
    var list: MutableList<Question> = generateDummyList(10).toMutableList()

    var currentPosition: Int = 0

    init {
        Log.d("xxx", "MainViewModel constructor")
    }

    fun addItem(item: Question) {
        list.add(item)
    }

    fun getItem(): Question {
        return list[currentPosition]
    }


    fun generateDummyList(size: Int): List<Question>{
        Log.d("xxx", "generateDummyList")

        val list = ArrayList<Question>()
        for (i in 0 until size){

            val item = Question(questions.get(i).text, questions.get(i).answers,questions.get(i).correctAnswer)
            list.add( item)
        }
        return list
    }
}
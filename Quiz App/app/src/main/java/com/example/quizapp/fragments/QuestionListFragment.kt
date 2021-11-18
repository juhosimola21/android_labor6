package com.example.quizapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.model.MainViewModel
import com.example.quizapp.model.questions


class QuestionListFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_question_list, container, false)
        Log.d("xxx", "ListFragment - onCreateView")

        //viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        // connect RecyclerView to the adapter
        val list = viewModel.generateDummyList(15)
        val adapter = QuestionAdapter(viewModel.list,this)

        val recycler_view : RecyclerView = view.findViewById(R.id.recycler_view)
        recycler_view.adapter = adapter

        recycler_view.layoutManager = LinearLayoutManager(this.context )
        recycler_view.setHasFixedSize(true)



        return view
    }
    fun detalis_onClick(position: Int) {
        viewModel.currentPosition = position
        findNavController().navigate(R.id.action_questionListFragment_to_questionDetailFragment)
        Log.d("xxx", "AdapterPosition: $position")
    }
    fun remove_onClick(position: Int){
        viewModel.currentPosition = position
        questions.removeAt(position)
        QuestionAdapter(viewModel.list,this).notifyItemRemoved(position)



    }
}
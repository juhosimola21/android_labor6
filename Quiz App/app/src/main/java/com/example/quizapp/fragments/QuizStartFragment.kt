package com.example.quizapp.fragments

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentQuizStartBinding
import com.example.quizapp.ui_user_interface.SharedViewModel
var game_name=" "
class QuizStartFragment : Fragment() {
    private val model: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentQuizStartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_start, container, false)
        val getContactList = registerForActivityResult(
            ActivityResultContracts.PickContact(),
            ActivityResultCallback {
                val list = listOf(ContactsContract.Contacts.DISPLAY_NAME).toTypedArray()
                val cursor = activity?.contentResolver?.query(it, list, null, null, null)
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        binding.editTextTextPersonName.setText(cursor.getString(0))
                    }
                    cursor.close()
                }
            })
        binding.button.setOnClickListener {
            getContactList.launch(null)
        }

        model.selected.observe(viewLifecycleOwner,  { item ->
            binding.editTextTextPersonName.text
        })
        binding.button2.setOnClickListener{
            this.findNavController().navigate(R.id.action_quizStartFragment_to_questionFragment)
        }

        return binding.root

    }


}
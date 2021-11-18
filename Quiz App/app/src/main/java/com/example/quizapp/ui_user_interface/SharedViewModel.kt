package com.example.quizapp.ui_user_interface

import android.content.ClipData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    val selected = MutableLiveData<ClipData.Item>()

    fun select(item: ClipData.Item) {
        selected.value = item
    }
}
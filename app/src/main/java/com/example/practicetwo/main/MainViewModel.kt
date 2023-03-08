package com.example.practicetwo.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val taskName = MutableLiveData("")
    val taskNumber = MutableLiveData("")

    fun checkValue(): Boolean {
        return taskName.value != "" && taskNumber.value != ""
    }
}
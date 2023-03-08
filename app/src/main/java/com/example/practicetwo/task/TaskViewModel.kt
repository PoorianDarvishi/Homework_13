package com.example.practicetwo.task

import androidx.lifecycle.ViewModel
import com.example.practicetwo.task.datas.Task
import com.example.practicetwo.task.enums.State

class TaskViewModel() : ViewModel() {
     lateinit var nameTask: String
     var numberTask: Int = 0
    private val listTask = arrayListOf<Task>()

    fun getListTask():ArrayList<Task>{
        return listTask
    }

    fun makeListTask() {
        for (num in 0 until numberTask) {
            listTask.add(Task(nameTask, State.values().random().name))
        }
    }

    fun addTask() {
        listTask.add(Task(nameTask, State.values().random().name))
    }
}
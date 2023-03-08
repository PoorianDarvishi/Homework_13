package com.example.practicetwo.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.practicetwo.R
import com.example.practicetwo.databinding.FragmentMainBinding
import com.example.practicetwo.task.TaskActivity
import com.example.practicetwo.task.TaskFragment

class MainFragment : Fragment(R.layout.fragment_main) {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding.apply {
            mainViewModel = viewModel
            lifecycleOwner = this@MainFragment
            buttonSubmit.setOnClickListener { checkAndGo() }
        }
    }

    private fun checkAndGo() {
        if (viewModel.checkValue()) toGoTaskPage()
    }

    private fun toGoTaskPage() {
        val intent = Intent(requireContext(), TaskActivity::class.java)
        intent.putExtra(TaskFragment.TASK_NAME, viewModel.taskName.value)
        intent.putExtra(TaskFragment.TASK_NUMBER, viewModel.taskNumber.value!!.toInt())
        startActivity(intent)
    }

}
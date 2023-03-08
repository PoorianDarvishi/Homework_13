package com.example.practicetwo.task

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicetwo.R
import com.example.practicetwo.databinding.FragmentTaskBinding
import com.example.practicetwo.task.adapter.Adapter
import com.example.practicetwo.task.datas.Task


class TaskFragment : Fragment(R.layout.fragment_task) {
    companion object {
        const val TASK_NAME = "TASK_NAME"
        const val TASK_NUMBER = "TASK_NUMBER"
    }

    private lateinit var binding: FragmentTaskBinding
    private val viewModel: TaskViewModel by viewModels()
    private lateinit var adapter: Adapter
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTaskBinding.bind(view)
        setTaskNameAndTaskNumber()
        setUpRecycler(viewModel.getListTask(), 1)
        binding.addTask.setOnClickListener {
            viewModel.addTask()
            adapter.notifyDataSetChanged()
        }
    }

    private fun setTaskNameAndTaskNumber() {
        viewModel.nameTask = requireActivity().intent.getStringExtra(TASK_NAME).toString()
        viewModel.numberTask = requireActivity().intent.getIntExtra(TASK_NUMBER, 0)
        viewModel.makeListTask()
    }


    private fun setUpRecycler(list: ArrayList<Task>, spanCount : Int) {
        adapter = Adapter(list)
        recyclerView = binding.recycler
        recyclerView.layoutManager = GridLayoutManager(requireContext(), spanCount)
        recyclerView.adapter = adapter
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if(newConfig.orientation == 2){
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        }else{
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        }
    }

}
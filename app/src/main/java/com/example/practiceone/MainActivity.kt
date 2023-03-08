package com.example.practiceone

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: Adapter
    private val viewModel: MainViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private val runnable = Runnable {
        viewModel.resetTextsColors()
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()


    }

    private fun setRecyclerView() {
        adapter = Adapter(viewModel.getItemList()) { color ->
            clickListener(color)
        }
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.adapter = adapter
    }

    fun clickListener(color: MyColor) {
        viewModel.removeColor(color)
        viewModel.changeTextsColors(color.backgroundColor)
        adapter.notifyDataSetChanged()
        recyclerView.handler.postDelayed(runnable, 5000)
    }

}
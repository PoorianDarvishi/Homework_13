package com.example.practiceone

import android.os.Bundle
import android.os.Handler
import android.view.View
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
    private val runnable  = Runnable { viewModel.resetTextsColors() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = Adapter(viewModel.getItemList()) { color ->
            viewModel.removeColor(color)
            viewModel.changeTextsColors(color.backgroundColor)
            adapter.notifyDataSetChanged()
            Handler().postDelayed(runnable,5000)
            adapter.notifyDataSetChanged()
        }
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.adapter = adapter

    }
}
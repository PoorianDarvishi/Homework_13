package com.example.practiceone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val items: ArrayList<Color>, private val click: (color: Color) -> Unit
) : RecyclerView.Adapter<Adapter.ViewHolderAdapter>() {
    class ViewHolderAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val frameColor: FrameLayout = itemView.findViewById(R.id.frameLayout)
        val colorName: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {
        return ViewHolderAdapter(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        holder.colorName.text = items[position].nameColor
        holder.colorName.setTextColor(android.graphics.Color.parseColor(items[position].textColor))
        holder.frameColor.apply {
            setBackgroundColor(android.graphics.Color.parseColor(items[position].backgroundColor))
            setOnClickListener {
                click(items[position])
            }
        }
    }
}
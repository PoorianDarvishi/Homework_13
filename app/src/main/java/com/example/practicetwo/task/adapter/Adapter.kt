package com.example.practicetwo.task.adapter



import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicetwo.R
import com.example.practicetwo.task.datas.Task

class Adapter(
    private val items: MutableList<Task>,
) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item : CardView = itemView.findViewById(R.id.mainCardView)
        val itemTitle: TextView = itemView.findViewById(R.id.tvNameTask)
        val itemDate: TextView = itemView.findViewById(R.id.tvAction)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_re, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position %2 == 0){
            holder.item.setCardBackgroundColor(Color.GREEN)
        }else{
            holder.item.setCardBackgroundColor(Color.BLUE)
        }
        holder.itemTitle.text = items[position].taskName
        holder.itemDate.text = items[position].action
    }


    override fun getItemCount(): Int {
        return items.size
    }
}
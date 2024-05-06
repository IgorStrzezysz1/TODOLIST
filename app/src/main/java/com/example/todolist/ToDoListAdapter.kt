package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.ToDoK
import com.google.android.material.transition.Hold

class ToDoListAdapter(private val data: List<ToDoK>) : RecyclerView.Adapter<ToDoKViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoKViewHolder {
        val view =LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return ToDoKViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ToDoKViewHolder, position: Int) {
        holder.nameTextView.text=data[position].title
    }

}
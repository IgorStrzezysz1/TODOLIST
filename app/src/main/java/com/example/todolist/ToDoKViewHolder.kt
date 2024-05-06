package com.example.todolist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoKViewHolder(view:View):RecyclerView.ViewHolder(view){
    val nameTextView: TextView
    init {
        nameTextView=view.findViewById(R.id.taskName)

    }
}
package com.example.todolist

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.ToDoKDatabase

class ToDoKViewHolder(view:View): RecyclerView.ViewHolder(view){
    val nameTextView: TextView
    val deleteButton: Button
    var toDoKId: Int? = null
    init {
        nameTextView = view.findViewById(R.id.taskName)
        deleteButton = view.findViewById(R.id.deleteButton)
        deleteButton.setOnClickListener {
            toDoKId?.let {
                ToDoKDatabase.getDataBase(view.context).toDoKAO().delete(it)
                view.context.startActivity(Intent(view.context, MainActivity::class.java))
            }
        }
    }
}
package com.example.todolist

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.ToDoKDatabase

/**
 * class containing individual node, to-do lists.
 */
class ToDoKViewHolder(view:View): RecyclerView.ViewHolder(view){
    /**
     * name ToDoK
     */
    val nameTextView: TextView

    /**
     * button that removes ToDoK from the database.
     */
    val deleteButton: Button

    /**
     * ID ToDoK
     */
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
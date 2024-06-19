package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.ToDoK

/**
 * ToDoK list adapter.
 */
class ToDoListAdapter(val data: MutableList<ToDoK>) : RecyclerView.Adapter<ToDoKViewHolder>() {
    /**
     * setting the entire list on a specific view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoKViewHolder {
        val view =LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return ToDoKViewHolder(view)
    }

    /**
     * specifying the size of the list of items
     */
    override fun getItemCount(): Int {
        return data.size
    }

    /**
     * setting a specific list item in a node.
     */
    override fun onBindViewHolder(holder: ToDoKViewHolder, position: Int) {
        holder.nameTextView.text=data[position].title
        holder.toDoKId = data[position].id
    }

}
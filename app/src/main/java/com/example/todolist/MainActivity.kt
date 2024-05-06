package com.example.todolist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.ToDoKDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var taskList: RecyclerView
    private lateinit var addButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            insets.also {
                it.getInsets(WindowInsetsCompat.Type.systemBars())
                    .let { inset ->
                        v.setPadding(inset.left, inset.top, inset.right, inset.bottom)
                    }
            }
        }

        val toDoDatabase = ToDoKDatabase.getDataBase(applicationContext.applicationContext)

        addButton = findViewById(R.id.addNewTask)
        taskList = findViewById(R.id.tasks)
        taskList.adapter=ToDoListAdapter(listOf())
    }
}
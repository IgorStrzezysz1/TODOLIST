package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.ToDoKDAO
import com.example.todolist.data.ToDoKDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var taskList: RecyclerView
    private lateinit var addButton: FloatingActionButton
    private lateinit var toDoKDAO: ToDoKDAO
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

        toDoKDAO = ToDoKDatabase.getDataBase(applicationContext).toDoKAO()

        addButton = findViewById(R.id.addNewTask)
        taskList = findViewById(R.id.tasks)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        taskList.layoutManager = linearLayoutManager

        taskList.adapter = ToDoListAdapter(toDoKDAO.getAll().toMutableList())

        addButton.setOnClickListener {
            startActivity(Intent(this, AddNewTodoActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

        taskList.adapter?.let {
            (it as ToDoListAdapter).data.clear()
            it.data.addAll(toDoKDAO.getAll())
            it?.notifyDataSetChanged()
        }
    }
}
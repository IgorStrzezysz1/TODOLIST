package com.example.todolist

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.ToDoKDAO
import com.example.todolist.data.ToDoKDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * ViewModel of the main activity.
 */
class MainActivity : AppCompatActivity() {
    /**
     *ToDocs list
     */
    internal lateinit var taskList: RecyclerView

    /**
     * button that fires up the activity of adding a new ToDoK.
     */
    internal lateinit var addButton: FloatingActionButton

    /**
     * ToDoK database.
     */
    internal lateinit var toDoKDAO: ToDoKDAO

    /**
     * view cosntruction - setting all activity mechanics.
     */
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
        viewInit(this)
    }

    /**
     * resume view
     */
    override fun onResume() {
        super.onResume()

        taskList.adapter?.let {
            (it as ToDoListAdapter).data.clear()
            it.data.addAll(toDoKDAO.getAll())
            it?.notifyDataSetChanged()
        }
    }
}

/**
 * initializing the ToDoK list.
 */
fun viewInit(activity: MainActivity){
    activity.toDoKDAO = ToDoKDatabase.getDataBase(activity.applicationContext).toDoKAO()

    activity.addButton = activity.findViewById(R.id.addNewTask)
    activity.taskList = activity.findViewById(R.id.tasks)

    val linearLayoutManager = LinearLayoutManager(activity)
    linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
    activity.taskList.layoutManager = linearLayoutManager

    activity.taskList.adapter = ToDoListAdapter(activity.toDoKDAO.getAll().toMutableList())

    activity.addButton.setOnClickListener {
        activity.startActivity(Intent(activity, AddNewTodoActivity::class.java))
    }}
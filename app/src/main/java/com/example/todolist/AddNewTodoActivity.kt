package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todolist.data.ToDoK
import com.example.todolist.data.ToDokStatus
import org.w3c.dom.Text
import java.time.Instant

class AddNewTodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_new_todo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.btnSave).setOnClickListener{
            val toDoK=ToDoK(title = findViewById<TextView>(R.id.edTitle).text.toString(),
                description = findViewById<TextView>(R.id.edDescription).text.toString(),
                creationDate= Instant.now(),
                status = ToDokStatus.NOT_STARTED,
                deadlineDate =
        }

    }

}


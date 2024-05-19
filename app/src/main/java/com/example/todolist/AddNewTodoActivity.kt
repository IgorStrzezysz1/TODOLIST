package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.todolist.data.ToDoK
import com.example.todolist.data.ToDoKDatabase
import com.example.todolist.data.ToDokStatus
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

class AddNewTodoActivity : AppCompatActivity() {

    private lateinit var toDoKDatabase: ToDoKDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_new_todo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toDoKDatabase = ToDoKDatabase.getDataBase(applicationContext)

        findViewById<Button>(R.id.btnSave).setOnClickListener{
            val title = findViewById<TextView>(R.id.edTitle).text
            val description = findViewById<TextView>(R.id.edDescription).text
            val year = findViewById<TextView>(R.id.edtYear).text
            var month = findViewById<TextView>(R.id.edtMonth).text

            var day = findViewById<TextView>(R.id.edtDay).text
            val toDoK=parseInput(title.toString(), description.toString(), year.toString(), month.toString(), day.toString())

                lifecycleScope.launch {
                    toDoK?.let { it1 ->
                        toDoKDatabase.toDoKAO().insert(it1)


                    }
                }
            if(toDoK !=null)
            startActivity(Intent(this, MainActivity::class.java))
            }
        }

    }

}


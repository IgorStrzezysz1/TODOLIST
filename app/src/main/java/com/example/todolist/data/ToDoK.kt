package com.example.todolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "Stuff_ToDo")
data class ToDoK(
    @PrimaryKey
    val id: Int?,

    val title: String,

    val description: String,

    val creationDate: Instant,

    val status: ToDokStatus,

    val deadlineDate: Instant
    )

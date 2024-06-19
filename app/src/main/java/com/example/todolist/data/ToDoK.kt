package com.example.todolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
/**
 * class representing the thing to do
 */
@Entity(tableName = "Stuff_ToDo")
data class ToDoK(
    @PrimaryKey
    val id: Int? = null,
    /**
    class representing the thing to do
     */
    val title: String,
    /**
     * Description to do
     */
    val description: String,
    /**
     * Setting a date for the task.
     */
    val creationDate: Instant,
    /**
     * Task status.
     */
    val status: ToDokStatus,
    /**
     * The end of the task by when it is to be completed.
     */
    val deadlineDate: Instant
)

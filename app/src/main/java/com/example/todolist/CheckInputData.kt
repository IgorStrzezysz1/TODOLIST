package com.example.todolist

import com.example.todolist.data.ToDoK
import com.example.todolist.data.ToDokStatus
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

fun checkInput(
    title: String,
    description: String,
    year: String,
    month: String,
    day: String
): Boolean {
    return (title.isNotBlank() && description.isNotBlank() && year.isNotBlank() && month.isNotBlank() && day.isNotBlank());
}
fun parseInput( title: String,
                description: String,
                year: String,
                month: String,
                day: String
):ToDoK?
{
if(checkInput(title, description,year, month, day)){
    val toDoK = ToDoK(
        title = title,
        description = description,
        creationDate= Instant.now(),
        status = ToDokStatus.NOT_STARTED,
        deadlineDate = LocalDate.of(
            year.toInt(),
            month.toInt(),
            day.toInt()
        ).atStartOfDay()
            .toInstant(ZoneOffset.UTC)
    )
        return toDoK;
    }
    return null}

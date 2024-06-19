package com.example.todolist

import com.example.todolist.data.ToDoK
import com.example.todolist.data.ToDokStatus
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

/**
 *  validation of entered data
 *  @param title task title
 *  @param description description of the task
 *  @param year year of adding task
 *  @param month month of adding task
 *  @param day of adding task
 *  @return true if data was entered correctly, otherwise false.
 */
fun checkInput(
    title: String,
    description: String,
    year: String,
    month: String,
    day: String
): Boolean {
    return (title.isNotBlank() && description.isNotBlank() && year.isNotBlank() && month.isNotBlank() && day.isNotBlank());
}

/**
 * convert the given data into a ToDoK object.
 * @param title task title
 * @param description description of the task.
 * @param year task year
 * @param month month of the task
 * @param day of the task
 * @return set instance of ToDoK
 */
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

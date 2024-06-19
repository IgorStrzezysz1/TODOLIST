package com.example.todolist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

/**
 * interface automatically generated database */
@Dao
interface ToDoKDAO {
    /**
     * retrieve all elements from the table.     */
    @Query("SELECT * FROM Stuff_ToDo")
    fun getAll() : List<ToDoK>

    /**
     * placement of a table element
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(toDoK: ToDoK)

    /**
     * removing items from the table
     */
    @Delete
    fun delete(toDoK: ToDoK)

    /**
     * removing a node from the table by the specified ID.
     */
    @Query("DELETE FROM Stuff_ToDo WHERE id = :id")
    fun delete(id: Int)

    /**
     * updates the specified element in the table
     */
    @Update
    suspend fun update(toDoK: ToDoK)

}
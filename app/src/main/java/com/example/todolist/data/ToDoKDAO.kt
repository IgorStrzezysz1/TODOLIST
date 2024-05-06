package com.example.todolist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToDoKDAO {

    @Query("SELECT * FROM Stuff_ToDo")
    suspend fun getAll() : List<ToDoK>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(toDoK: ToDoK)

    @Delete
    suspend fun delete(toDoK: ToDoK)

    @Update
    suspend fun update(toDoK: ToDoK)

//
//    @Query("Delete FROM Stuff_ToDo WHERE :id=id")
//    fun delete(id: Int)

}
package com.example.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ToDoK::class], version=1)
@TypeConverters(DateConverter::class)
abstract class ToDoKDatabase: RoomDatabase() {

    abstract fun toDoKAO():ToDoKDAO

    companion object{
        @Volatile
        private var Instance: ToDoKDatabase? = null

        fun getDataBase(context:Context):ToDoKDatabase{
            return Instance ?: synchronized(this){

                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = ToDoKDatabase::class.java,
                    name = "MyDatabase"
                )
                    .build()
                    .also {
                        Instance = it
                    }


            }
        }
    }

}
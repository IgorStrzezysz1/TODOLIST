package com.example.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * ToDoK database.
 */
@Database(entities = [ToDoK::class], version=1)
@TypeConverters(DateConverter::class)
abstract class ToDoKDatabase: RoomDatabase() {

    abstract fun toDoKAO():ToDoKDAO

    companion object{
        /**
         * Database Institution To DoK.
         */
        @Volatile
        private var Instance: ToDoKDatabase? = null

        /**
         * the database will be constructed if it has not been created.
         * @param context aplication context
         * @return built database
         */
        fun getDataBase(context:Context):ToDoKDatabase{
            return Instance ?: synchronized(this){

                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = ToDoKDatabase::class.java,
                    name = "MyDatabase"
                )
                    .allowMainThreadQueries()
                    .build()
                    .also {
                        Instance = it
                    }


            }
        }
    }

}
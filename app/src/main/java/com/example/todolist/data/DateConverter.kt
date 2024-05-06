package com.example.todolist.data

import androidx.room.TypeConverter
import java.time.Instant

class DateConverter {

    @TypeConverter
    fun fromTimestamp(time: Long?): Instant? = time?.let { Instant.ofEpochMilli(it) }


    @TypeConverter
    fun toTimestamp(instant: Instant?): Long? = instant?.toEpochMilli()


}
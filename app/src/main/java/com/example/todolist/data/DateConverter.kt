package com.example.todolist.data

import androidx.room.TypeConverter
import java.time.Instant

/**
 * DateConverter class is used to convert between data types.
 */
class DateConverter {
    /**
     * converting a date stored as a number of milliseconds from 1970.01.01 00:00 to a date instance.
     */
    @TypeConverter
    fun fromTimestamp(time: Long?): Instant? = time?.let { Instant.ofEpochMilli(it) }

    /**
     * conversion of date isntation to number of milliseconds since 1970.01.01 00:00.
     */
    @TypeConverter
    fun toTimestamp(instant: Instant?): Long? = instant?.toEpochMilli()


}
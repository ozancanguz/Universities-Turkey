package com.ozancanguz.universities_turkey.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities =
[UniversityEntity::class], version = 1,
    exportSchema = false)

@TypeConverters(TypeConverter::class)
abstract class UniDatabase:RoomDatabase() {

    abstract fun uniDao():UniDao


}
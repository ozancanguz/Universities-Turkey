package com.ozancanguz.universities_turkey.data.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities =
[UniversityEntity::class], version = 1,
    exportSchema = false)

abstract class UniDatabase:RoomDatabase() {

    abstract fun uniDao():UniDao


}
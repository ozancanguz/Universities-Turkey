package com.ozancanguz.universities_turkey.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ozancanguz.universities_turkey.data.model.University

@Entity(tableName = "university_table")

class UniversityEntity(

    var university: University

) {

    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}
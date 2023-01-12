package com.ozancanguz.universities_turkey.data.db

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ozancanguz.universities_turkey.data.model.University

class TypeConverter {

    var gson = Gson()

    @androidx.room.TypeConverter
    fun UniToString(university: University): String {
        return gson.toJson(university)
    }

    @androidx.room.TypeConverter
    fun stringToUni(data: String): University {
        val listType = object : TypeToken<University>() {}.type
        return gson.fromJson(data, listType)
    }
}
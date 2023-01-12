package com.ozancanguz.universities_turkey.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

@Dao
interface UniDao {

    @Query("SELECT* FROM university_table order by id ASC")
    fun listAllUniversities(): Flow<List<UniversityEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversity(universityEntity: UniversityEntity)

}
package com.ozancanguz.universities_turkey.data.localdatasource

import com.ozancanguz.universities_turkey.data.db.UniDao
import com.ozancanguz.universities_turkey.data.db.UniversityEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LocalDataSource@Inject constructor(private val uniDao: UniDao) {


    fun listAllUniversities(): Flow<List<UniversityEntity>>{
        return uniDao.listAllUniversities()
    }

    suspend fun insertUniversity(universityEntity: UniversityEntity){
         return uniDao.insertUniversity(universityEntity)
    }

}
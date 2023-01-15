package com.ozancanguz.universities_turkey.data.remotedatasource

import com.ozancanguz.universities_turkey.data.api.UniversityApi
import com.ozancanguz.universities_turkey.data.model.University
import retrofit2.Response
import javax.inject.Inject


class RemoteDataSource@Inject constructor(private val universityApi: UniversityApi) {

    suspend fun getUniversityList():Response<University>{
        return universityApi.getUniversityList()
    }


    suspend fun searchUniversity(searchQuery: Map<String, String>):Response<University>{
        return universityApi.SearchUniversity(searchQuery)
    }

}
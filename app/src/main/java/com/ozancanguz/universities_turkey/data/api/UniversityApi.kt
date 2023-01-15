package com.ozancanguz.universities_turkey.data.api

import com.ozancanguz.universities_turkey.data.model.University
import retrofit2.Response
import retrofit2.http.GET

interface UniversityApi {


    @GET("search?")
    suspend fun getUniversityList(): Response<University>




}
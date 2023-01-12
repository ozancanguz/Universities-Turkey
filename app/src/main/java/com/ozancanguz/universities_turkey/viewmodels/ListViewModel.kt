package com.ozancanguz.universities_turkey.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.ozancanguz.universities_turkey.data.Repository
import com.ozancanguz.universities_turkey.data.db.UniversityEntity
import com.ozancanguz.universities_turkey.data.model.University
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel@Inject constructor(val repository: Repository,application: Application)
    :AndroidViewModel(application) {

    // ----------RETROFIT
        var universityList=MutableLiveData<University>()
        var job: Job?=null


    // ------------ROOM
    var universityEntityList:LiveData<List<UniversityEntity>> = repository.local.listAllUniversities().asLiveData()


    // for room insert university to database
    fun insertUniversity(universityEntity: UniversityEntity){
        viewModelScope.launch {
            repository.local.insertUniversity(universityEntity)
        }
    }

    // save to db
    fun saveUniToDb(university: University){
        var university=UniversityEntity(university)
        insertUniversity(university)
    }



    // ----------RETROFIT REQUEST
    fun requestApiData(){
        job= CoroutineScope(Dispatchers.IO).launch {

            val response=repository.remote.getUniversityList()
            if(response.isSuccessful){
                universityList.postValue(response.body())

                val universities=universityList.value!!
                saveUniToDb(universities)

            }else{
                Log.d("listviewmodel","no data"+response.body())
            }

        }
    }


}
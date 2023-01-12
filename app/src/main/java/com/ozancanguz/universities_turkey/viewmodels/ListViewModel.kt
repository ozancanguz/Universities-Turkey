package com.ozancanguz.universities_turkey.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozancanguz.universities_turkey.data.Repository
import com.ozancanguz.universities_turkey.data.model.University
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


class ListViewModel@Inject constructor(val repository: Repository,application: Application)
    :AndroidViewModel(application) {

        var universityList=MutableLiveData<University>()
        var job: Job?=null


    fun requestApiData(){
        job= CoroutineScope(Dispatchers.IO).launch {

            val response=repository.remote.getUniversityList()
            if(response.isSuccessful){
                universityList.postValue(response.body())

            }else{
                Log.d("listviewmodel","no data"+response.body())
            }

        }
    }


}
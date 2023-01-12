package com.ozancanguz.universities_turkey.data

import com.ozancanguz.universities_turkey.data.remotedatasource.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository@Inject constructor(remoteDataSource: RemoteDataSource) {

    var remote=remoteDataSource
}
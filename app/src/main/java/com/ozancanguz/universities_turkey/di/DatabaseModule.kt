package com.ozancanguz.universities_turkey.di

import android.content.Context
import androidx.room.Room
import com.ozancanguz.universities_turkey.data.db.UniDao
import com.ozancanguz.universities_turkey.data.db.UniDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        UniDatabase::class.java,
        "uni_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: UniDatabase) = database.uniDao()

}

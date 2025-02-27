package com.bhavesh.janitriassignment.di

import android.content.Context
import androidx.room.Room
import com.bhavesh.janitriassignment.data.database.VitalsDao
import com.bhavesh.janitriassignment.data.database.VitalsDatabase
import com.bhavesh.janitriassignment.domain.repository.VitalsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): VitalsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            VitalsDatabase::class.java,
            "vitals_db"
        ).build()
    }

    @Provides
    fun provideVitalsDao(database: VitalsDatabase): VitalsDao = database.vitalsDao()

    @Provides
    @Singleton
    fun provideVitalsRepository(vitalsDao: VitalsDao) : VitalsRepository = VitalsRepository(vitalsDao)
}
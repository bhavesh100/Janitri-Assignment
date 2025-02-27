package com.bhavesh.janitriassignment.domain.repository

import com.bhavesh.janitriassignment.data.model.Vitals
import com.bhavesh.janitriassignment.data.database.VitalsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VitalsRepository @Inject constructor( val vitalsDao: VitalsDao) {
    val allVitals: Flow<List<Vitals>> = vitalsDao.getAllVitals()

    suspend fun insertVitals(vitals: Vitals) {
        vitalsDao.insertVitals(vitals)
    }
}
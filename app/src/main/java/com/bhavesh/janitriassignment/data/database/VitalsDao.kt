package com.bhavesh.janitriassignment.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bhavesh.janitriassignment.data.model.Vitals
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVitals(vitals: Vitals)

    @Query("SELECT * FROM vitals ORDER BY id DESC")
    fun getAllVitals(): Flow<List<Vitals>>
}
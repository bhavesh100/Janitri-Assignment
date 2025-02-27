package com.bhavesh.janitriassignment.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bhavesh.janitriassignment.data.model.Vitals

@Database(entities = [Vitals::class], version = 1, exportSchema = false)
abstract class VitalsDatabase : RoomDatabase() {
    abstract fun vitalsDao(): VitalsDao
}
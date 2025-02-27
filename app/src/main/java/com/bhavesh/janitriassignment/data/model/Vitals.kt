package com.bhavesh.janitriassignment.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vitals")
data class Vitals(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bloodPressureSys: Int,
    val bloodPressureDia: Int,
    val heartRate: Int,
    val weight: Float,
    val babyKicks: Int
)
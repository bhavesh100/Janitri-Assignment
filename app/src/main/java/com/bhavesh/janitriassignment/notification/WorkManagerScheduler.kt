package com.bhavesh.janitriassignment.notification

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

object WorkManagerScheduler {
    fun scheduleVitalsReminder(context: Context) {
            val workRequest = PeriodicWorkRequestBuilder<VitalsReminderWorker>(5, TimeUnit.HOURS)
            .setConstraints(
                Constraints.Builder()
                    .setRequiresBatteryNotLow(true)
                    .build()
            )
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "VitalsReminder",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }
}

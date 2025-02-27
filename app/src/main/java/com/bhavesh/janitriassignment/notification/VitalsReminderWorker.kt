package com.bhavesh.janitriassignment.notification

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class VitalsReminderWorker(
    private val context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        NotificationHelper.showNotification(context)
        return Result.success()
    }
}

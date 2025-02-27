package com.bhavesh.janitriassignment.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bhavesh.janitriassignment.notification.WorkManagerScheduler
import com.bhavesh.janitriassignment.ui.theme.JanitriAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JanitriAssignmentTheme {
                MainScreen()
            }
        }
        WorkManagerScheduler.scheduleVitalsReminder(this)
    }
}
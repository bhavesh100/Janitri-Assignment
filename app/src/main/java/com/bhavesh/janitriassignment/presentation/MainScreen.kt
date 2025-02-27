package com.bhavesh.janitriassignment.presentation

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bhavesh.janitriassignment.notification.NotificationHelper
import com.bhavesh.janitriassignment.presentation.composables.AddVitalsDialog
import com.bhavesh.janitriassignment.presentation.composables.VitalsItem
import com.bhavesh.janitriassignment.presentation.viewmodel.VitalsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: VitalsViewModel = hiltViewModel()) {
    val vitalsList by viewModel.vitalsList.collectAsState()

    var showDialog by remember { mutableStateOf(false) }

//    var context = LocalContext.current
//    val intent = Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS)
//    context.startActivity(intent)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Track My Pregnancy",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF562095)
                    )
                        },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFC1ADF5))
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    "+",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(vitalsList.size) { index ->
                VitalsItem(vitalsList[index])
            }
        }


        if (showDialog) {
            AddVitalsDialog(
                onDismiss = { showDialog = false },
                onSave = { vitals ->
                    viewModel.insertVitals(vitals)
                    showDialog = false
                }
            )
        }
    }
}
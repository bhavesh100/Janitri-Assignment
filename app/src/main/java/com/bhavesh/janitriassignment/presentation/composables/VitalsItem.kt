package com.bhavesh.janitriassignment.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhavesh.janitriassignment.R
import com.bhavesh.janitriassignment.data.model.Vitals
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun VitalsItem(vitals: Vitals) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding( start = 15.dp, end = 15.dp, top = 7.dp, bottom = 7.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xFFE1BAF8))
    ){
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(50.dp)
            ) {
                VitalStat(R.drawable.monitor_heart, "${vitals.heartRate} bpm")
                VitalStat(R.drawable.blood_pressure, "${vitals.bloodPressureSys}/${vitals.bloodPressureDia} mmHg")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(50.dp)
            ) {
                VitalStat(R.drawable.monitor_weight, "${vitals.weight} kg")
                VitalStat(R.drawable.child, "${vitals.babyKicks} kicks")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFF9150B3)
                    )
                    .padding(
                        horizontal = 10.dp
                    ),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = formatDate(0),
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
    }
}

@Composable
fun VitalStat(iconRes: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Color(0xFF1A013D),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = Color(0xFF1A013D),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

fun formatDate(timestamp: Long): String {
    val sdf = SimpleDateFormat("EEE, dd MMM yyyy hh:mm a", Locale.getDefault())
    return sdf.format(Date(timestamp))
}

package com.aamir.compose.glucorx_task.core.presentation

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Util {
    fun formatTimestamp(timestamp: Long): String {
        val formatter = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
        return formatter.format(Date(timestamp))
    }
}
package com.aamir.compose.glucorx_task.presentation.ui.news.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorMessage(
    message:String
){
    Text("Error: $message")
}

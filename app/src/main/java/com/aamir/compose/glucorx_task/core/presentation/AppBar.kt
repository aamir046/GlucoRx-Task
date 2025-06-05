package com.aamir.compose.glucorx_task.core.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
            )
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        )
    )
}
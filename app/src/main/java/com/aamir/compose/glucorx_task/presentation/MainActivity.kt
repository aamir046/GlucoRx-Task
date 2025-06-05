package com.aamir.compose.glucorx_task.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aamir.compose.glucorx_task.presentation.ui.news.NewsScreenRoot
import com.aamir.compose.glucorx_task.presentation.ui.news.NewsViewModel
import com.aamir.compose.glucorx_task.presentation.theme.GlucoRxTaskTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlucoRxTaskTheme {
                val viewModel = koinViewModel<NewsViewModel>()
                NewsScreenRoot(viewModel)
            }
        }
    }
}
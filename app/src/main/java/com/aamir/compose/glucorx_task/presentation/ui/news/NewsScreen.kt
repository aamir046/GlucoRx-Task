package com.aamir.compose.glucorx_task.presentation.ui.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aamir.compose.glucorx_task.core.presentation.AppBar
import com.aamir.compose.glucorx_task.presentation.ui.news.components.ErrorMessage
import com.aamir.compose.glucorx_task.presentation.ui.news.components.NewsList

@Composable
fun NewsScreenRoot(viewModel: NewsViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    NewsScreen(
        uiState = uiState,
        modifier = Modifier
    )
}

@Composable
fun NewsScreen(
    uiState: NewsUiState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { AppBar(title = "GlucoRX-Task") }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            when (uiState) {
                is NewsUiState.Loading -> CircularProgressIndicator(
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )

                is NewsUiState.Error -> ErrorMessage(uiState.message)
                is NewsUiState.Success -> NewsList(uiState.articles)
            }
        }
    }
}

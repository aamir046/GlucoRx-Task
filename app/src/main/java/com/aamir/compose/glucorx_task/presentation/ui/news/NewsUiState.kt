package com.aamir.compose.glucorx_task.presentation.ui.news

import com.aamir.compose.glucorx_task.domain.model.Article

sealed class NewsUiState {
    data object Loading : NewsUiState()
    data class Success(val articles: List<Article>) : NewsUiState()
    data class Error(val message: String) : NewsUiState()
}
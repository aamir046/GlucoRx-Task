package com.aamir.compose.glucorx_task.presentation.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aamir.compose.glucorx_task.domain.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(private val repo: NewsRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)
    val uiState: StateFlow<NewsUiState> = _uiState

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            _uiState.value = NewsUiState.Loading
            val result = repo.getCombinedNews()
            _uiState.value = result.fold(
                onSuccess = { NewsUiState.Success(it) },
                onFailure = { NewsUiState.Error(it.message ?: "Unknown Error") }
            )
        }
    }
}
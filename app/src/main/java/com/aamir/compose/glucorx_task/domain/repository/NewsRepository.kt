package com.aamir.compose.glucorx_task.domain.repository

import com.aamir.compose.glucorx_task.domain.model.Article

interface NewsRepository {
    suspend fun getCombinedNews(): Result<List<Article>>
}
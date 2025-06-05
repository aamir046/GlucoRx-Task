package com.aamir.compose.glucorx_task.domain.source

import com.aamir.compose.glucorx_task.domain.model.Article

interface NewsSource {
    suspend fun fetchArticles(): List<Article>
}
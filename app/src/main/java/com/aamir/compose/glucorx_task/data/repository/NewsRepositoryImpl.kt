package com.aamir.compose.glucorx_task.data.repository

import com.aamir.compose.glucorx_task.domain.model.Article
import com.aamir.compose.glucorx_task.domain.repository.NewsRepository
import com.aamir.compose.glucorx_task.domain.source.NewsSource

class NewsRepositoryImpl(
    private val sources: List<NewsSource>
) : NewsRepository {
    override suspend fun getCombinedNews(): Result<List<Article>> {
        val allArticles = mutableListOf<Article>()
        val errors = mutableListOf<String>()

        sources.forEach { source ->
            try {
                allArticles += source.fetchArticles()
            } catch (e: Exception) {
                errors += e.message ?: "Unknown error"
            }
        }
        return if (allArticles.isNotEmpty())
            Result.success(allArticles.sortedBy { it.publishDate })
        else
            Result.failure(Exception(errors.joinToString()))
    }
}
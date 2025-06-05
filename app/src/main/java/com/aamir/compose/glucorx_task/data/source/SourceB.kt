package com.aamir.compose.glucorx_task.data.source

import com.aamir.compose.glucorx_task.domain.model.Article
import com.aamir.compose.glucorx_task.domain.source.NewsSource
import kotlinx.coroutines.delay

class SourceB : NewsSource {
    override suspend fun fetchArticles(): List<Article> {
        delay((1000..3000).random().toLong())
        if ((1..100).random() <= 24) throw Exception("Source B failed")
        return listOf(
            Article("B1 Headline", "Source B", System.currentTimeMillis() - 800000),
            Article("B2 Headline", "Source B", System.currentTimeMillis() - 200000)
        )
    }
}
package com.aamir.compose.glucorx_task.data.source

import com.aamir.compose.glucorx_task.domain.model.Article
import com.aamir.compose.glucorx_task.domain.source.NewsSource
import kotlinx.coroutines.delay

class SourceA : NewsSource {
    override suspend fun fetchArticles(): List<Article> {
        delay((1000..3000).random().toLong())
        if ((1..100).random() <= 24) throw Exception("Source A failed")
        return listOf(
            Article("A1 Headline", "Source A", System.currentTimeMillis() - 1000000),
            Article("A2 Headline", "Source A", System.currentTimeMillis() - 300000)
        )
    }
}
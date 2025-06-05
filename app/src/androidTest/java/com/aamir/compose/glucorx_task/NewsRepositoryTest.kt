package com.aamir.compose.glucorx_task

import com.aamir.compose.glucorx_task.data.repository.NewsRepositoryImpl
import com.aamir.compose.glucorx_task.domain.model.Article
import com.aamir.compose.glucorx_task.domain.source.NewsSource
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NewsRepositoryTest {

    @Test
    fun testSourceSuccessAndFailure() = runTest {
        val sourceSuccess = object : NewsSource {
            override suspend fun fetchArticles(): List<Article> = listOf(
                Article("Test", "Test", System.currentTimeMillis())
            )
        }
        val sourceFail = object : NewsSource {
            override suspend fun fetchArticles(): List<Article> {
                throw Exception("Failed")
            }
        }

        val repo = NewsRepositoryImpl(listOf(sourceSuccess, sourceFail))
        val result = repo.getCombinedNews()
        assert(result.isSuccess)
        assert(result.getOrNull()?.size == 1)
    }

}
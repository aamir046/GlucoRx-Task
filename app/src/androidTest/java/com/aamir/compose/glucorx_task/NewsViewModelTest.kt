package com.aamir.compose.glucorx_task

import com.aamir.compose.glucorx_task.domain.model.Article
import com.aamir.compose.glucorx_task.domain.repository.NewsRepository
import com.aamir.compose.glucorx_task.presentation.ui.news.NewsUiState
import com.aamir.compose.glucorx_task.presentation.ui.news.NewsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NewsViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun viewModelSuccess() = runTest {
        // Mock repo returning success
        val fakeArticles = listOf(
            Article("Test 1", "Source A", 12345L),
            Article("Test 2", "Source B", 54321L)
        )
        val mockRepo = object : NewsRepository {
            override suspend fun getCombinedNews(): Result<List<Article>> {
                return Result.success(fakeArticles)
            }
        }

        val viewModel = NewsViewModel(mockRepo)

        // Advance coroutine
        testDispatcher.scheduler.advanceUntilIdle()

        assert(viewModel.uiState.value is NewsUiState.Success)
        assert((viewModel.uiState.value as NewsUiState.Success).articles == fakeArticles)
    }

    @Test
    fun viewModelError() = runTest {
        val mockRepo = object : NewsRepository {
            override suspend fun getCombinedNews(): Result<List<Article>> {
                return Result.failure(Exception("Simulated failure"))
            }
        }

        val viewModel = NewsViewModel(mockRepo)

        testDispatcher.scheduler.advanceUntilIdle()

        assert(viewModel.uiState.value is NewsUiState.Error)
        assert((viewModel.uiState.value as NewsUiState.Error).message == "Simulated failure")
    }
}

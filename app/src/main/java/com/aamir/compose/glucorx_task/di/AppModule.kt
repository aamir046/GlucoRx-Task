package com.aamir.compose.glucorx_task.di

import com.aamir.compose.glucorx_task.data.repository.NewsRepositoryImpl
import com.aamir.compose.glucorx_task.data.source.SourceA
import com.aamir.compose.glucorx_task.data.source.SourceB
import com.aamir.compose.glucorx_task.domain.repository.NewsRepository
import com.aamir.compose.glucorx_task.domain.source.NewsSource
import com.aamir.compose.glucorx_task.presentation.ui.news.NewsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single<NewsSource>(named("sourceA")) { SourceA() }
    single<NewsSource>(named("sourceB")) { SourceB() }
    single<NewsRepository> {
        NewsRepositoryImpl(
            sources = listOf(get(named("sourceA")), get(named("sourceB")))
        )
    }
    viewModel { NewsViewModel(get()) }
}
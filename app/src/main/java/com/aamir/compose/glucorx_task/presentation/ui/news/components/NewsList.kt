package com.aamir.compose.glucorx_task.presentation.ui.news.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aamir.compose.glucorx_task.core.presentation.Util
import com.aamir.compose.glucorx_task.domain.model.Article

@Composable
fun NewsList(articles: List<Article>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(articles) { article ->
            ContentNewsList(
                modifier = Modifier.padding(4.dp),
                article = article
            )
        }
    }
}

@Composable
fun ContentNewsList(
    modifier: Modifier,
    article: Article
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = article.title)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = article.sourceName)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Published: ${Util.formatTimestamp(article.publishDate)}")
        }
    }
}

@Preview(apiLevel = 34, showBackground = true, device = Devices.PIXEL)
@Composable
fun HorizontalBooksListingPreview() {
    Surface {
        NewsList(
            listOf(
                Article(
                    title = "Title 1",
                    sourceName = "Source 1",
                    publishDate = System.currentTimeMillis()
                ),
                Article(
                    title = "Title 2",
                    sourceName = "Source 2",
                    publishDate = System.currentTimeMillis()
                ),
            )
        )
    }
}
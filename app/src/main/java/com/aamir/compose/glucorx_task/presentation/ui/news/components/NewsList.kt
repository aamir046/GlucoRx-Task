package com.aamir.compose.glucorx_task.presentation.ui.news.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aamir.compose.glucorx_task.domain.model.Article
import java.util.Date

@Composable
fun NewsList(articles: List<Article>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles) { article ->
            Row(modifier = Modifier.padding(8.dp)) {
                Column {
                    Text(text = article.title)
                    Text(text = article.sourceName)
                    Text(text = "Published: ${Date(article.publishDate)}")
                }
            }
        }
    }
}


@Preview(apiLevel = 34, showBackground = true, device = Devices.PIXEL)
@Composable
fun HorizontalBooksListingPreview() {
    Surface {
        NewsList(listOf())
    }
}
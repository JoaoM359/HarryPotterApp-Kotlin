package com.example.harrypotterapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.harrypotterapp.viewmodel.HPCharsViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HPCharsScreen(viewModel: HPCharsViewModel = HPCharsViewModel()) {
    val posts by viewModel.posts.observeAsState(emptyList())
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text("Posts", style = MaterialTheme.typography.bodyMedium)
            LazyColumn {
                items(posts) { post ->
                    Text(post.name, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }


    viewModel.fetchPosts()
}
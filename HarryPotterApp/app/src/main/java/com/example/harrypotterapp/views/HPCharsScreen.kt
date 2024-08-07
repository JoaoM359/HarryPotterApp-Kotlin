package com.example.harrypotterapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.harrypotterapp.viewmodel.HPCharsViewModel

@Composable
fun HPCharsScreen(viewModel: HPCharsViewModel = HPCharsViewModel()) {
    val hpCharacters by viewModel.hpchars.observeAsState(emptyList())

    Column(Modifier.padding(16.dp)) {
        Text("Harry Potter Characters", style = MaterialTheme.typography.bodyMedium)
        LazyColumn {
            items(hpCharacters) { hpCharacter ->
                Box(modifier = Modifier.padding(12.dp)) {

                    Column {
                        Text(hpCharacter.name, style = MaterialTheme.typography.bodyMedium)

                        Image(
                            painter = rememberImagePainter(if (hpCharacter.image != "") hpCharacter.image else "https://ih1.redbubble.net/image.1893341687.8294/fposter,small,wall_texture,product,750x1000.jpg"),
                            contentDescription = null,
                            modifier = Modifier.size(300.dp, 150.dp)
                        )
                    }

                }
            }
        }

    }

    viewModel.fetchPosts()
}
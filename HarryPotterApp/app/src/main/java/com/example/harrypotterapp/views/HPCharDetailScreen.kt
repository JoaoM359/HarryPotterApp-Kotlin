package com.example.harrypotterapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun HPCharDetailScreen(
    name: String?,
    house: String?,
    species: String?,
    gender: String?,
    image: String?
) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = rememberImagePainter(image),
                contentDescription = null,
                modifier = Modifier.size(300.dp, 150.dp)
            )
            Text(text = "Name", fontWeight = FontWeight.Bold)
            Text(text = "$name")
            Text(text = "House", fontWeight = FontWeight.Bold)
            Text(text = "$house")
            Text(text = "Species",fontWeight = FontWeight.Bold)
            Text(text = "Species: $species")
            Text(text = "Gender", fontWeight = FontWeight.Bold)
            Text(text = "$gender")
        }
    }
}
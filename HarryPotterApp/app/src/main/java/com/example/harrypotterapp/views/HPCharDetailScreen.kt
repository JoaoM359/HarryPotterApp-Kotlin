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
import androidx.compose.ui.platform.testTag
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
                modifier = Modifier
                    .size(300.dp, 150.dp)
                    .testTag("charImage")
            )

            Text(
                text = "Name",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.testTag("nameTitle")
            )
            Text(
                text = "$name",
                modifier = Modifier.testTag("nameValue")
            )

            Text(
                text = "House",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.testTag("houseTitle")
            )
            Text(
                text = "$house",
                modifier = Modifier.testTag("houseValue")
            )

            Text(
                text = "Species",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.testTag("speciesTitle")
            )
            Text(
                text = "Species: $species",
                modifier = Modifier.testTag("speciesValue")
            )

            Text(
                text = "Gender",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.testTag("genderTitle")
            )
            Text(
                text = "$gender",
                modifier = Modifier.testTag("genderValue")
            )
        }
    }
}
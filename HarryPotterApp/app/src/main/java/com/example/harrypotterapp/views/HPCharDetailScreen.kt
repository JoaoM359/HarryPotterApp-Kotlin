package com.example.harrypotterapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
    image: String?,
    backgroundRed: Float?,
    backgroundGreen: Float?,
    backgroundBlue: Float?
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(
                    backgroundRed ?: 0.5f,
                    backgroundGreen ?: 0.5f,
                    backgroundBlue ?: 0.5f,
                    1f
                )
            )

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .size(400.dp, 500.dp)
                    .padding(16.dp)
                    .testTag("charImage"),
                painter = rememberImagePainter(image),
                contentDescription = null

            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "Name",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.testTag("nameTitle")
            )
            Text(
                text = "$name",
                modifier = Modifier.testTag("nameValue")
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "House",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.testTag("houseTitle")
            )
            Text(
                text = "$house",
                modifier = Modifier.testTag("houseValue")
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "Species",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.testTag("speciesTitle")
            )
            Text(
                text = "$species",
                modifier = Modifier.testTag("speciesValue")
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "Gender",
                style = MaterialTheme.typography.headlineSmall,
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
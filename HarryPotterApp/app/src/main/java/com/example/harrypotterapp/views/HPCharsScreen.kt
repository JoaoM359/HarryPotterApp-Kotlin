package com.example.harrypotterapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.harrypotterapp.viewmodel.HPCharsViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun HPCharsScreen(viewModel: HPCharsViewModel = HPCharsViewModel(), navController: NavController) {
    val hpCharacters by viewModel.hpchars.observeAsState(emptyList())
    val notFoundImageURL =
        "https://www.pngkey.com/png/full/21-213224_unknown-person-icon-png-download.png"

    Column(
        Modifier
            .padding(16.dp)
            .fillMaxSize()
            .testTag("charsColumn"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Harry Potter Characters",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.testTag("title")
        )

        LazyColumn(modifier = Modifier.padding(horizontal = 75.dp)) {
            items(hpCharacters) { hpCharacter ->

                Button(
                    onClick = {
                        navController.navigate(
                            Screen.HPCharDetailScreen.withArgs(
                                if (hpCharacter.name != "") hpCharacter.name else "Not Defined",
                                if (hpCharacter.house != "") hpCharacter.house else "Not Defined",
                                if (hpCharacter.species != "") hpCharacter.species else "Not Defined",
                                if (hpCharacter.gender != "") hpCharacter.gender else "Not Defined",
                                if (hpCharacter.image != "") URLEncoder.encode(
                                    hpCharacter.image,
                                    StandardCharsets.UTF_8.toString()
                                )
                                else URLEncoder.encode(
                                    notFoundImageURL,
                                    StandardCharsets.UTF_8.toString()
                                ),
                                viewModel.colorForHouse(hpCharacter.house).red.toString(),
                                viewModel.colorForHouse(hpCharacter.house).green.toString(),
                                viewModel.colorForHouse(hpCharacter.house).blue.toString()
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .testTag("${hpCharacter.name.lowercase()}Button"),
                    colors = ButtonDefaults.buttonColors(viewModel.colorForHouse(hpCharacter.house)),

                    ) {
                    Box(modifier = Modifier.padding(12.dp)) {

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                hpCharacter.name,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )

                            Image(
                                modifier = Modifier
                                    .size(100.dp, 150.dp)
                                    .clip(RoundedCornerShape(18.dp)),
                                painter = rememberImagePainter(if (hpCharacter.image != "") hpCharacter.image else notFoundImageURL),
                                contentDescription = null,
                                )
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(5.dp))
            }
        }
    }

    viewModel.fetchPosts()
}
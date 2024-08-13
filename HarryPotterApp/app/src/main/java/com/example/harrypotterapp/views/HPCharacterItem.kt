package com.example.harrypotterapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.harrypotterapp.model.HPCharacter
import com.example.harrypotterapp.viewmodel.HPCharsViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun HPCharacterItem(
    hpCharacter: HPCharacter,
    viewModel: HPCharsViewModel,
    navController: NavController
) {
    val notFoundImageURL =
        "https://www.pngkey.com/png/full/21-213224_unknown-person-icon-png-download.png"
    val notDefinedValue = "Not Defined"

    Button(
        onClick = {
            navController.navigate(
                Screen.HPCharDetailScreen.withArgs(
                    if (hpCharacter.name != "") hpCharacter.name else notDefinedValue,
                    if (hpCharacter.house != "") hpCharacter.house else notDefinedValue,
                    if (hpCharacter.species != "") hpCharacter.species else notDefinedValue,
                    if (hpCharacter.gender != "") hpCharacter.gender else notDefinedValue,
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
            .testTag("${hpCharacter.name.lowercase()}Button"),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(viewModel.colorForHouse(hpCharacter.house)),

        ) {


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    hpCharacter.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Button(
                    onClick = { viewModel.updateFavButtonColor() },
                    modifier = Modifier.size(25.dp),
                    colors = ButtonDefaults.buttonColors(viewModel.favButtonColor)
                ) {

                }
            }

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
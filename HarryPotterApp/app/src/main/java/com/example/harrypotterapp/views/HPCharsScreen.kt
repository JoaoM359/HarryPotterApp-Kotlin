package com.example.harrypotterapp.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.harrypotterapp.viewmodel.HPCharsViewModel

@Composable
fun HPCharsScreen(viewModel: HPCharsViewModel = HPCharsViewModel(), navController: NavController) {
    val hpCharacters by viewModel.hpchars.observeAsState(emptyList())


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
        //dgd
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(5.dp)
        ) {
            for (house in viewModel.houses) {
                Button(
                    onClick = {
                        viewModel.updateCharsByHouse(house)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .weight(1f)
                        .padding(horizontal = 5.dp),
                    colors = ButtonDefaults.buttonColors(viewModel.colorForHouse(house))
                ) {

                }
            }
        }
        LazyColumn(modifier = Modifier.padding(horizontal = 25.dp)) {
            items(hpCharacters) { hpCharacter ->

                HPCharacterItem(
                    hpCharacter = hpCharacter,
                    viewModel = viewModel,
                    navController = navController
                )

                Spacer(modifier = Modifier.padding(5.dp))
            }
        }
    }

    viewModel.fetchPosts()
}
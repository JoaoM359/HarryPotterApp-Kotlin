package com.example.harrypotterapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
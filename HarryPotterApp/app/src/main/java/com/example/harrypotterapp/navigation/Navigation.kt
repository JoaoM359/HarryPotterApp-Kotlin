package com.example.harrypotterapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.harrypotterapp.views.HPCharsScreen
import com.example.harrypotterapp.views.HPCharDetailScreen
import com.example.harrypotterapp.views.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HPCharsScreen.route) {
        composable(route = Screen.HPCharsScreen.route) {
            HPCharsScreen(navController = navController)
        }
        composable(
            route = Screen.HPCharDetailScreen.route + "/{name}/{house}/{species}/{gender}/{image}/{backgroundRed}/{backgroundGreen}/{backgroundBlue}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("house") {
                    type = NavType.StringType
                },
                navArgument("species") {
                    type = NavType.StringType
                },
                navArgument("gender") {
                    type = NavType.StringType
                },
                navArgument("image") {
                    type = NavType.StringType
                },
                navArgument("backgroundRed") {
                    type = NavType.FloatType
                },
                navArgument("backgroundGreen") {
                    type = NavType.FloatType
                },
                navArgument("backgroundBlue") {
                    type = NavType.FloatType
                }
            )
        ) { entry ->
            HPCharDetailScreen(
                name = entry.arguments?.getString("name"),
                house = entry.arguments?.getString("house"),
                species = entry.arguments?.getString("species"),
                gender = entry.arguments?.getString("gender"),
                image = entry.arguments?.getString("image"),
                backgroundRed = entry.arguments?.getFloat("backgroundRed"),
                backgroundGreen = entry.arguments?.getFloat("backgroundGreen"),
                backgroundBlue = entry.arguments?.getFloat("backgroundBlue"),
            )
        }
    }
}
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
            route = Screen.HPCharDetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Philip"
                    nullable = true
                }
            )
        ) { entry ->
            HPCharDetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}
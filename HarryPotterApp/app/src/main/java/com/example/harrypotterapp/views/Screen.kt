package com.example.harrypotterapp.views

sealed class Screen(val route: String) {
    object HPCharsScreen: Screen("HPCharsScreen")
    object HPCharDetailScreen: Screen("HPCharDetailScreen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
        }
    }
}

}
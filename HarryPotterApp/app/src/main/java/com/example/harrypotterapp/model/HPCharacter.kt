package com.example.harrypotterapp.model

data class HPCharacter(
    var id: String,
    var name: String,
    var house: String,
    var species: String,
    var gender: String,
    var image: String,
    var isFavorite: Boolean = false
)
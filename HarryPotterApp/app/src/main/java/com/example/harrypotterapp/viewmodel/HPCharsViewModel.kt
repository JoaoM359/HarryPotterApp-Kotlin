package com.example.harrypotterapp.viewmodel

import android.util.Log
import androidx.annotation.ColorRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotterapp.model.HPCharacter
import com.example.harrypotterapp.service.RetrofitInstance
import kotlinx.coroutines.launch

class HPCharsViewModel : ViewModel() {
    private val hpcharacters = MutableLiveData<List<HPCharacter>>()
    val hpchars: LiveData<List<HPCharacter>> = hpcharacters
    var favButtonColor by mutableStateOf(Color.Black)

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getChars()
                hpcharacters.value = response
                Log.i("SUCCESS", "on response: $response")

            } catch (e: Exception) {
                Log.i("ERROR", "on response: ${e.message}")
            }
        }
    }

    fun colorForHouse(house: String): Color {

        val houseColor = when (house.lowercase()) {
            "slytherin" -> Color(0.2f, 0.318f, 0.149f, 1.0f)
            "hufflepuff" -> Color(0.918f, 0.753f, 0.231f, 1.0f)
            "gryffindor" -> Color(0.588f, 0.251f, 0.255f, 1.0f)
            "ravenclaw" -> Color(0.227f, 0.224f, 0.294f, 1.0f)
            else -> {
                Color.Gray
            }
        }
        return houseColor
    }

    fun updateFavButtonColor() {
        if (this.favButtonColor == Color.Black) {
            this.favButtonColor = Color.Red
        } else {
            this.favButtonColor = Color.Black
        }
    }
}
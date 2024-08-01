package com.example.harrypotterapp.service

import com.example.harrypotterapp.model.HPCharacter
import retrofit2.http.GET

interface HPApiService {

    @GET("api/characters")
    suspend fun getChars(): List<HPCharacter>
}
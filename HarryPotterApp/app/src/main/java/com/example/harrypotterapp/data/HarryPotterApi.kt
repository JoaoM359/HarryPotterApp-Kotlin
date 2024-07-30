package com.example.harrypotterapp.data

import com.example.harrypotterapp.model.HPCharacter
import retrofit2.Call
import retrofit2.http.GET

interface HarryPotterApi {

    @GET("characters")
    fun getCharacters(): Call<List<HPCharacter>>
}
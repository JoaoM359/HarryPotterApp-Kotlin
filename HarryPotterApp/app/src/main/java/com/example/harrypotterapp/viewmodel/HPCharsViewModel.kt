package com.example.harrypotterapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.harrypotterapp.model.HPCharacter
import com.example.harrypotterapp.service.RetrofitInstance

class HPCharsViewModel : ViewModel() {
    private val hpcharacters = MutableLiveData<List<HPCharacter>>()
    val hpchars: LiveData<List<HPCharacter>> = hpcharacters

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getChars()
                hpcharacters.value = response
                Log.i("SUCESS","on response: $response")

            } catch (e: Exception) {
                Log.i("ERROR","on response: ${e.message}")
            }
        }
    }
}
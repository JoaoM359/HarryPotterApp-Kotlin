package com.example.harrypotterapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.harrypotterapp.data.HarryPotterApi
import com.example.harrypotterapp.model.HPCharacter
import com.example.harrypotterapp.ui.theme.HarryPotterAppTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HarryPotterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    getAllCharacters()
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

private fun getAllCharacters(){
    val api = Retrofit.Builder()
        .baseUrl("http://hp-api.onrender.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(HarryPotterApi::class.java)

    api.getCharacters().enqueue(object : Callback<List<HPCharacter>> {
        override fun onResponse(call: Call<List<HPCharacter>>, response: Response<List<HPCharacter>>) {
            Log.i("SUCCESS", "chega aqui")
            if (response.isSuccessful) {

                response.body()?.let {
                    for (character in it ) {
                        Log.i("SUCCESS", "on Response: ${character.name}")
                    }
                }
            }
        }

        override fun onFailure(call: Call<List<HPCharacter>>, t: Throwable) {
            Log.i("FAILURE", "on Response: ${t.message}")
        }

    })
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


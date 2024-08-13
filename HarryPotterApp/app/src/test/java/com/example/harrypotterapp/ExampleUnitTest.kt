package com.example.harrypotterapp

import androidx.compose.ui.graphics.Color
import com.example.harrypotterapp.viewmodel.HPCharsViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testHouseColor() {
        val viewModel = HPCharsViewModel()

        assertEquals(Color(1f,0f,0f,0.5f), viewModel.colorForHouse("gryffindor"))
        assertEquals(Color(0f,1f,0f,0.5f), viewModel.colorForHouse("slytherin"))
        assertEquals(Color(1f,1f,0f,0.5f), viewModel.colorForHouse("hufflepuff"))
        assertEquals(Color(0f,0f,1f,0.5f), viewModel.colorForHouse("ravenclaw"))
        assertEquals(Color.Gray, viewModel.colorForHouse("Not Defined"))
    }
}
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

        assertEquals(Color(0.588f, 0.251f, 0.255f, 1.0f), viewModel.colorForHouse("gryffindor"))
        assertEquals(Color(0.2f, 0.318f, 0.149f, 1.0f), viewModel.colorForHouse("slytherin"))
        assertEquals(Color(0.918f, 0.753f, 0.231f, 1.0f), viewModel.colorForHouse("hufflepuff"))
        assertEquals(Color(0.227f, 0.224f, 0.294f, 1.0f), viewModel.colorForHouse("ravenclaw"))
        assertEquals(Color.Gray, viewModel.colorForHouse("Not Defined"))
    }
}
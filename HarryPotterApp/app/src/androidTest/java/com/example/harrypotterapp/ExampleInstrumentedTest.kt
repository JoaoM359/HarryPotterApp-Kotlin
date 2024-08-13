package com.example.harrypotterapp

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.harrypotterapp.navigation.Navigation
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.harrypotterapp", appContext.packageName)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun showList() {

        composeTestRule.setContent {

            Navigation()
        }

        // Column
        composeTestRule.onNodeWithTag("charsColumn").assertExists()
        composeTestRule.onNodeWithTag("charsColumn").assertIsDisplayed()

        //Title
        composeTestRule.onNodeWithTag("title").assertExists()
        composeTestRule.onNodeWithTag("title").assertIsDisplayed()

        //Button
        composeTestRule.waitUntilAtLeastOneExists(hasTestTag("harry potterButton"))
        composeTestRule.onNodeWithTag("harry potterButton").assertExists()
        composeTestRule.onNodeWithTag("harry potterButton").assertIsDisplayed()
        composeTestRule.onNodeWithTag("harry potterButton").performClick()

        //Details Screen
        composeTestRule.onNodeWithTag("charImage").assertExists()
        composeTestRule.onNodeWithTag("nameTitle").assertExists()
        composeTestRule.onNodeWithTag("nameValue").assertIsDisplayed()

        composeTestRule.onNodeWithTag("houseTitle").assertExists()
        composeTestRule.onNodeWithTag("houseValue").assertIsDisplayed()

        composeTestRule.onNodeWithTag("speciesTitle").assertExists()
        composeTestRule.onNodeWithTag("speciesValue").assertIsDisplayed()

        composeTestRule.onNodeWithTag("genderTitle").assertExists()
        composeTestRule.onNodeWithTag("genderValue").assertIsDisplayed()

    }
}
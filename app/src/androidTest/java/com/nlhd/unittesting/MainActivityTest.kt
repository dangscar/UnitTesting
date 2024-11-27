package com.nlhd.unittesting

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        composeTestRule.setContent {
            MainScreen()
        }

        composeTestRule.onNodeWithText("Continue").performClick()
        composeTestRule.onNodeWithText("Welcome to the Main Screen!").assertExists()
    }

    @Test
    fun text_screen() {
        composeTestRule.setContent {
            TextScreen()
        }

        val text = composeTestRule.onNodeWithTag("text")
        text.assertExists()
        text.assertTextEquals("AAAA")
    }

    @Test
    fun text_field_test() {
        composeTestRule.setContent {
            MyTextField()
        }
        // Find the TextField by its test tag
        val textField = composeTestRule.onNodeWithTag("MyTextField")
        // Assert it exists
        textField.assertExists()
        // Wait for the UI to settle
        composeTestRule.waitForIdle()
        // Verify the input text is reflected in the UI
        textField.performTextInput("Hello Compose")
        composeTestRule.waitForIdle()
        textField.assert(hasText("Hello Compose"))

    }

}
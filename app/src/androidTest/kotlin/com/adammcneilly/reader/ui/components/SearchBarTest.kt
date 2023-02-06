package com.adammcneilly.reader.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.adammcneilly.reader.setReaderContent
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class SearchBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun renderEmptySearchBar() {
        composeTestRule.setReaderContent {
            SearchBar(
                value = "",
                onValueChange = {},
            )
        }

        composeTestRule.onNodeWithText("Search").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Search Icon").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Clear Text").assertDoesNotExist()
    }

    @Test
    fun renderFilledSearchBar() {
        composeTestRule.setReaderContent {
            SearchBar(
                value = "The Expanse",
                onValueChange = {},
            )
        }

        composeTestRule.onNodeWithText("Search").assertDoesNotExist()
        composeTestRule.onNodeWithText("The Expanse").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Search Icon").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Clear Text").assertIsDisplayed()
    }

    @Test
    fun handleClearTextClicked() {
        var latestValueChange: String? = null

        composeTestRule.setReaderContent {
            SearchBar(
                value = "The Expanse",
                onValueChange = { newValue ->
                    latestValueChange = newValue
                },
            )
        }

        composeTestRule.onNodeWithText("Search").assertDoesNotExist()
        composeTestRule.onNodeWithText("The Expanse").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Search Icon").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Clear Text").assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Clear Text").performClick()

        assertEquals("", latestValueChange)
    }
}

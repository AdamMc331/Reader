package com.adammcneilly.reader.library

import androidx.compose.ui.test.junit4.createComposeRule
import com.adammcneilly.reader.displaymodels.BookDisplayModel
import com.adammcneilly.reader.setReaderContent
import org.junit.Rule
import org.junit.Test

class LibraryContentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun renderEmptyBooks() {
        val viewState = LibraryViewState(
            unreadBooks = emptyList(),
            readBooks = emptyList(),
        )

        composeTestRule.setReaderContent {
            LibraryContent(viewState)
        }

        libraryScreenRobot(composeTestRule) {
            assertUnreadHeaderGone()
            assertReadHeaderGone()
        }
    }

    @Test
    fun renderUnreadBooks() {
        val bookTitle = "Test Title"

        val book = BookDisplayModel(
            title = bookTitle,
        )

        val viewState = LibraryViewState(
            unreadBooks = listOf(book),
            readBooks = emptyList(),
        )

        composeTestRule.setReaderContent {
            LibraryContent(viewState)
        }

        libraryScreenRobot(composeTestRule) {
            assertUnreadHeaderDisplayed()
            assertBookTitleDisplayed(bookTitle)
            assertReadHeaderGone()
        }
    }

    @Test
    fun renderReadBooks() {
        val bookTitle = "Test Title"

        val book = BookDisplayModel(
            title = bookTitle,
        )

        val viewState = LibraryViewState(
            unreadBooks = emptyList(),
            readBooks = listOf(book),
        )

        composeTestRule.setReaderContent {
            LibraryContent(viewState)
        }

        libraryScreenRobot(composeTestRule) {
            assertUnreadHeaderGone()
            assertReadHeaderDisplayed()
            assertBookTitleDisplayed(bookTitle)
        }
    }
}

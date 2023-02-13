package com.adammcneilly.reader.library

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText

class LibraryScreenRobot(
    private val composeTestRule: ComposeTestRule,
) {
    private val readHeader = composeTestRule.onNodeWithText("Read")
    private val unreadHeader = composeTestRule.onNodeWithText("Unread")

    fun assertReadHeaderDisplayed() {
        readHeader.assertIsDisplayed()
    }

    fun assertReadHeaderGone() {
        readHeader.assertDoesNotExist()
    }

    fun assertUnreadHeaderDisplayed() {
        unreadHeader.assertIsDisplayed()
    }

    fun assertUnreadHeaderGone() {
        unreadHeader.assertDoesNotExist()
    }

    /**
     * Note that, because our application code may force a title component to wrap to two lines,
     * we want to do a substring check here because it's possible the title is rendered as something
     * like "Test Title\n".
     */
    fun assertBookTitleDisplayed(
        bookTitle: String,
    ) {
        composeTestRule
            .onNodeWithText(
                text = bookTitle,
                substring = true,
            )
            .assertIsDisplayed()
    }
}

fun libraryScreenRobot(
    composeTestRule: ComposeTestRule,
    block: LibraryScreenRobot.() -> Unit,
) {
    LibraryScreenRobot(composeTestRule).apply(block)
}

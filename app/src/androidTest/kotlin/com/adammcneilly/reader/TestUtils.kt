package com.adammcneilly.reader

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import com.adammcneilly.reader.ui.theme.ReaderTheme

/**
 * Renders the supplied [content] inside a [Surface] using the [ReaderTheme].
 */
fun ComposeContentTestRule.setReaderContent(
    content: @Composable () -> Unit
) {
    this.setContent {
        ReaderTheme {
            Surface {
                content()
            }
        }
    }
}

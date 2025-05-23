package com.adammcneilly.reader.screens.search

import androidx.compose.ui.text.input.TextFieldValue
import com.adammcneilly.reader.BasePaparazziTest
import org.junit.Test

class SearchContentPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderDefault() {
        snapshot {
            SearchContent(
                state = SearchState.default(),
            )
        }
    }

    @Test
    fun renderFilled() {
        snapshot {
            SearchContent(
                state = SearchState(
                    query = TextFieldValue("Lord of the Rings"),
                ),
            )
        }
    }
}

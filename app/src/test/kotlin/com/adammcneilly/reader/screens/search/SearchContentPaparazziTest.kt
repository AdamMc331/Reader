package com.adammcneilly.reader.screens.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.input.TextFieldValue
import com.adammcneilly.reader.BasePaparazziTest
import com.adammcneilly.reader.R
import com.adammcneilly.reader.core.app.AppState
import com.adammcneilly.reader.core.app.AppStateData
import com.adammcneilly.reader.core.app.HomeTab
import com.adammcneilly.reader.core.app.LocalAppState
import com.adammcneilly.reader.core.displaymodels.AuthorDisplayModel
import com.adammcneilly.reader.core.displaymodels.BookDisplayModel
import com.adammcneilly.reader.core.displaymodels.ImageDisplayModel
import org.junit.Test

class SearchContentPaparazziTest : BasePaparazziTest() {
    private val searchAppState = AppState(
        initialData = AppStateData(
            selectedTab = HomeTab.Search,
        ),
    )

    @Test
    fun renderDefault() {
        snapshot(
            screenPaddingDp = 0,
        ) {
            CompositionLocalProvider(
                LocalAppState provides searchAppState,
            ) {
                SearchContent(
                    state = SearchState.default(),
                    onEvent = {},
                    contentPadding = PaddingValues(),
                )
            }
        }
    }

    @Test
    fun renderFilled() {
        snapshot(
            screenPaddingDp = 0,
        ) {
            CompositionLocalProvider(
                LocalAppState provides searchAppState,
            ) {
                SearchContent(
                    state = SearchState(
                        query = TextFieldValue("Androids"),
                        books = List(3) { index ->
                            BookDisplayModel(
                                id = index.toString(),
                                title = "Androids",
                                coverImage = ImageDisplayModel.Local(R.drawable.androids),
                                author = AuthorDisplayModel(
                                    id = "123",
                                    name = "Chet Haase",
                                    image = ImageDisplayModel.Local(R.drawable.chet),
                                ),
                            )
                        },
                    ),
                    onEvent = {},
                    contentPadding = PaddingValues(),
                )
            }
        }
    }
}

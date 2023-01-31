package com.adammcneilly.reader.booksearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.reader.displaymodels.BookDisplayModel
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.components.BookSearchResultListItem
import com.adammcneilly.reader.ui.components.SearchBar
import com.adammcneilly.reader.ui.theme.ReaderTheme

@Composable
fun BookSearchContent(
    viewState: BookSearchViewState,
    onSearchTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(ReaderTheme.spacing.verticalListSpacing),
    ) {
        SearchBar(
            value = viewState.searchText,
            onValueChange = onSearchTextChange,
        )

        if (viewState.results.isNotEmpty()) {
            LazyColumn {
                itemsIndexed(viewState.results) { index, displayModel ->
                    BookSearchResultListItem(
                        displayModel = displayModel,
                    )

                    if (index != viewState.results.lastIndex) {
                        Divider()
                    }
                }
            }
        }
    }
}

@Composable
@DayNightPreview
private fun InitialBookSearchContentPreview() {
    val viewState = BookSearchViewState(
        searchText = "",
        results = emptyList(),
    )

    ReaderTheme {
        Surface {
            BookSearchContent(
                viewState = viewState,
                onSearchTextChange = {},
            )
        }
    }
}

@Composable
@DayNightPreview
private fun ActiveBookSearchContentPreview() {
    val viewState = BookSearchViewState(
        searchText = "The Expanse",
        results = listOf(
            BookDisplayModel(
                id = "1",
                title = "Leviathan Wakes",
                author = "James S.A. Corey",
            ),
            BookDisplayModel(
                id = "2",
                title = "Caliban's War",
                author = "James S.A. Corey",
            ),
            BookDisplayModel(
                id = "3",
                title = "Abaddon's Gate",
                author = "James S.A. Corey",
            ),
        ),
    )

    ReaderTheme {
        Surface {
            BookSearchContent(
                viewState = viewState,
                onSearchTextChange = {},
            )
        }
    }
}

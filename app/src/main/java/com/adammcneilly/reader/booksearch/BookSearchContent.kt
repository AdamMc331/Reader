package com.adammcneilly.reader.booksearch

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    onBookClicked: (String) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(ReaderTheme.sizing.verticalListSpacing),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(
            all = ReaderTheme.sizing.screenPadding,
        ),
    ) {
        item {
            SearchBar(
                value = viewState.searchText,
                onValueChange = onSearchTextChange,
            )
        }

        item {
            AnimatedVisibility(visible = viewState.isLoadingBooks) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.small),
                )
            }
        }

        if (viewState.results.isNotEmpty()) {
            itemsIndexed(viewState.results) { index, displayModel ->
                BookSearchResultListItem(
                    displayModel = displayModel,
                    modifier = Modifier
                        .clickable {
                            onBookClicked.invoke(displayModel.id)
                        },
                )

                if (index != viewState.results.lastIndex) {
                    Divider()
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
                thumbnailURL = null,
                isInLibrary = true,
            ),
            BookDisplayModel(
                id = "2",
                title = "Caliban's War",
                author = "James S.A. Corey",
                thumbnailURL = null,
                isInLibrary = false,
            ),
            BookDisplayModel(
                id = "3",
                title = "Abaddon's Gate",
                author = "James S.A. Corey",
                thumbnailURL = null,
                isInLibrary = false,
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

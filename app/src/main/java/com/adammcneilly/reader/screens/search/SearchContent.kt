package com.adammcneilly.reader.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.adammcneilly.reader.R
import com.adammcneilly.reader.core.displaymodels.AuthorDisplayModel
import com.adammcneilly.reader.core.displaymodels.BookDisplayModel
import com.adammcneilly.reader.core.displaymodels.ImageDisplayModel
import com.adammcneilly.reader.core.ui.components.BookOverviewCard
import com.adammcneilly.reader.core.ui.theme.ReaderTheme

@Composable
fun SearchContent(
    state: SearchState,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                SearchInput(state)
            }

            items(
                items = state.books,
                key = { book -> book.id },
            ) { book ->
                BookOverviewCard(
                    book = book,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
        }
    }
}

@Composable
private fun SearchInput(
    state: SearchState,
) {
    OutlinedTextField(
        value = state.query,
        onValueChange = {
        },
        placeholder = {
            Text(
                text = stringResource(R.string.search),
            )
        },
        shape = CircleShape,
        modifier = Modifier
            .fillMaxWidth(),
    )
}

@Suppress("MagicNumber")
class SearchStateProvider :
    CollectionPreviewParameterProvider<SearchState>(
        collection = listOf(
            SearchState.default(),
            SearchState(
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
        ),
    )

@Composable
@PreviewLightDark
@PreviewFontScale
@PreviewDynamicColors
private fun SearchContentPreview(
    @PreviewParameter(SearchStateProvider::class) searchState: SearchState,
) {
    ReaderTheme {
        SearchContent(
            state = searchState,
        )
    }
}

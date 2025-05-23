package com.adammcneilly.reader.screens.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
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
        ) {
            item {
                SearchInput(state)
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

class SearchStateProvider :
    CollectionPreviewParameterProvider<SearchState>(
        collection = listOf(
            SearchState.default(),
            SearchState(
                query = TextFieldValue("Lord of the Rings"),
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

package com.adammcneilly.reader.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.reader.displaymodels.BookDisplayModel
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.theme.ReaderTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookSearchResultListItem(
    displayModel: BookDisplayModel,
    modifier: Modifier = Modifier,
) {
    ListItem(
        modifier = modifier,
        headlineText = {
            Text(
                text = displayModel.title,
            )
        },
        supportingText = {
            Text(
                text = displayModel.author,
            )
        },
    )
}

@Composable
@DayNightPreview
private fun BookSearchResultCardPreview() {
    val displayModel = BookDisplayModel(
        id = "1",
        title = "Leviathan Wakes",
        author = "James S.A. Corey",
        thumbnailURL = null,
    )

    ReaderTheme {
        Surface {
            BookSearchResultListItem(
                displayModel = displayModel,
            )
        }
    }
}

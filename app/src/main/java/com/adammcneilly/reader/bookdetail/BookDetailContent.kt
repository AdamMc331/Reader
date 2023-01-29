package com.adammcneilly.reader.bookdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adammcneilly.reader.R
import com.adammcneilly.reader.displaymodels.BookDisplayModel
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.theme.ReaderTheme

@Composable
fun BookDetailContent(
    viewState: BookDetailViewState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(ReaderTheme.spacing.verticalListSpacing),
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_book_24),
            contentDescription = stringResource(R.string.book_cover_content_description),
            modifier = Modifier.size(60.dp),
        )

        Text(
            text = viewState.book.title,
            style = MaterialTheme.typography.bodyLarge,
        )

        Text(
            text = viewState.book.author,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@Composable
@DayNightPreview
private fun BookDetailContentPreview() {
    val displayModel = BookDisplayModel(
        title = "Leviathan Wakes",
        author = "James S.A. Corey",
    )

    val viewState = BookDetailViewState(
        book = displayModel,
    )

    ReaderTheme {
        Surface {
            BookDetailContent(
                viewState = viewState,
            )
        }
    }
}
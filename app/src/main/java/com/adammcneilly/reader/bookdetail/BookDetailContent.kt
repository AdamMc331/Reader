package com.adammcneilly.reader.bookdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(ReaderTheme.sizing.screenPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(ReaderTheme.sizing.verticalListSpacing),
        ) {
            AsyncImage(
                model = "https://books.google.com/books/content?id=yud-foXqGUEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                contentDescription = stringResource(R.string.book_cover_content_description),
                modifier = Modifier
                    .height(360.dp)
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.FillHeight,
            )

            Text(
                text = viewState.book.title,
                style = MaterialTheme.typography.headlineLarge,
            )

            Text(
                text = viewState.book.author,
                style = MaterialTheme.typography.titleLarge,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp,
                    ),
                )
                .padding(16.dp),
        ) {
            Text(
                text = "Book info",
                style = MaterialTheme.typography.titleSmall,
            )

            Row {
                Text(
                    text = "Title",
                    modifier = Modifier
                        .weight(1F),
                )

                Text(
                    text = "Leviathan Wakes",
                )
            }

            Divider()

            Row {
                Text(
                    text = "Authors",
                    modifier = Modifier
                        .weight(1F),
                )

                Text(
                    text = "James S.A. Corey",
                )
            }

            Divider()

            Row {
                Text(
                    text = "Number of pages",
                    modifier = Modifier
                        .weight(1F),
                )

                Text(
                    text = "534",
                )
            }
        }
    }
}

@Composable
@DayNightPreview
private fun BookDetailContentPreview() {
    val displayModel = BookDisplayModel(
        id = "1",
        title = "Leviathan Wakes",
        author = "James S.A. Corey",
        thumbnailURL = null,
        isInLibrary = true,
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

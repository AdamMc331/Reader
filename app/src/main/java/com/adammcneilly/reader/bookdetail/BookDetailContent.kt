package com.adammcneilly.reader.bookdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
            .background(MaterialTheme.colorScheme.primaryContainer)
            .verticalScroll(rememberScrollState()),
    ) {
        BookCoverTitle(viewState)

        BookInfoSheet(viewState)
    }
}

@Composable
private fun BookInfoSheet(
    viewState: BookDetailViewState,
) {
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
        val yourAttrs = listOf(
            "Reading Status" to "Finished",
            "Pages Read" to "534 pages (100%)",
            "Finish date" to "February 27, 2023",
            "Your Rating" to "5 Stars",
        )

        AttributeList(title = "Your Info", attributes = yourAttrs)

        Spacer(modifier = Modifier.height(16.dp))

        val attributes = listOf(
            "Title" to viewState.book.title,
            "Authors" to viewState.book.author,
            "Number of pages" to viewState.book.numPages.toString(),
        )

        AttributeList(title = "Book Info", attributes = attributes)
    }
}

@Composable
private fun AttributeList(
    title: String,
    attributes: List<Pair<String, String>>,
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
    )

    attributes.forEachIndexed { index, (key, value) ->
        BookAttributeListItem(
            name = key,
            value = value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = ReaderTheme.sizing.listItemPadding,
                ),
        )

        if (index != attributes.lastIndex) {
            Divider()
        }
    }
}

@Composable
private fun BookCoverTitle(viewState: BookDetailViewState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(ReaderTheme.sizing.screenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(ReaderTheme.sizing.verticalListSpacing),
    ) {
        AsyncImage(
            model = viewState.book.thumbnailURL,
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
}

@Composable
@DayNightPreview
@Suppress("MaxLineLength")
private fun BookDetailContentPreview() {
    val displayModel = BookDisplayModel(
        id = "1",
        title = "Leviathan Wakes",
        author = "James S.A. Corey",
        thumbnailURL = "https://books.google.com/books/content?id=yud-foXqGUEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
        isInLibrary = true,
        numPages = 534,
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

package com.adammcneilly.reader.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.adammcneilly.reader.displaymodels.BookDisplayModel
import com.adammcneilly.reader.ui.theme.ReaderTheme

private const val IMAGE_ASPECT_RATIO = 0.75F
private const val TITLE_MAX_LINES = 2

@Composable
fun LibraryBookListItem(
    displayModel: BookDisplayModel,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
    ) {
        AsyncImage(
            model = displayModel.thumbnailURL,
            contentDescription = "${displayModel.title} Cover",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(IMAGE_ASPECT_RATIO),
            contentScale = ContentScale.Crop,
        )

        TitleAndAuthor(displayModel)
    }
}

@Composable
private fun TitleAndAuthor(displayModel: BookDisplayModel) {
    Column(
        modifier = Modifier
            .padding(ReaderTheme.sizing.listItemPadding),
    ) {
        var titleLines by remember { mutableStateOf(0) }

        val calculatedTitle = buildString {
            append(displayModel.title)

            // Add empty lines so that the line count matches that of
            // TITLE_MAX_LINES
            for (i in titleLines..TITLE_MAX_LINES) {
                append("\n ")
            }
        }

        Text(
            text = calculatedTitle,
            style = MaterialTheme.typography.headlineSmall,
            maxLines = TITLE_MAX_LINES,
            onTextLayout = { result ->
                titleLines = result.lineCount
            },
        )

        Text(
            text = displayModel.author,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

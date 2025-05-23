package com.adammcneilly.reader.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adammcneilly.reader.R
import com.adammcneilly.reader.core.displaymodels.AuthorDisplayModel
import com.adammcneilly.reader.core.displaymodels.BookDisplayModel
import com.adammcneilly.reader.core.displaymodels.ImageDisplayModel
import com.adammcneilly.reader.core.ui.theme.ReaderTheme

private const val COVER_IMAGE_ASPECT_RATIO = 0.75F

@Composable
fun BookOverviewCard(
    book: BookDisplayModel,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(16.dp),
        ) {
            CoverImage(book)

            Column {
                BookTitle(book)

                AuthorName(book)
            }
        }
    }
}

@Composable
private fun AuthorName(
    book: BookDisplayModel,
) {
    Text(
        text = book.author.name,
        style = MaterialTheme.typography.labelMedium,
    )
}

@Composable
private fun BookTitle(
    book: BookDisplayModel,
) {
    Text(
        text = book.title,
        style = MaterialTheme.typography.titleMedium,
    )
}

@Composable
private fun CoverImage(
    book: BookDisplayModel,
) {
    ImageWrapper(
        image = book.coverImage,
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .height(100.dp)
            .aspectRatio(COVER_IMAGE_ASPECT_RATIO)
            .clip(MaterialTheme.shapes.small),
    )
}

@Composable
@PreviewLightDark
@PreviewFontScale
@PreviewDynamicColors
private fun BookOverviewCardPreview() {
    ReaderTheme {
        BookOverviewCard(
            book = BookDisplayModel(
                id = "123",
                title = "Androids",
                coverImage = ImageDisplayModel.Local(R.drawable.androids),
                author = AuthorDisplayModel(
                    id = "123",
                    name = "Chet Haase",
                    image = ImageDisplayModel.Local(R.drawable.chet),
                ),
            ),
        )
    }
}

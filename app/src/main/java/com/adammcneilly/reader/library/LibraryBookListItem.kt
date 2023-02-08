package com.adammcneilly.reader.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.adammcneilly.reader.displaymodels.BookDisplayModel
import com.adammcneilly.reader.ui.theme.ReaderTheme

private const val IMAGE_ASPECT_RATIO = 0.75F

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
        Text(
            text = displayModel.title,
            style = MaterialTheme.typography.headlineSmall,
        )

        Text(
            text = displayModel.author,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

package com.adammcneilly.reader.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.filled.BookmarkAdded
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.SubcomposeAsyncImage
import com.adammcneilly.reader.R
import com.adammcneilly.reader.displaymodels.BookDisplayModel
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.theme.ReaderTheme
import com.google.accompanist.placeholder.material3.placeholder

private const val IMAGE_ASPECT_RATIO = 0.70F

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
        leadingContent = {
            SubcomposeAsyncImage(
                model = displayModel.thumbnailURL,
                contentDescription = "${displayModel.title} Cover",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(ReaderTheme.sizing.searchResultImageWidth)
                    .aspectRatio(IMAGE_ASPECT_RATIO)
                    .clip(MaterialTheme.shapes.small),
                loading = {
                    ImagePlaceholder()
                },
                error = {
                    ImagePlaceholder()
                },
            )
        },
        trailingContent = {
            val (icon, contentDescriptionRes) = when {
                displayModel.isInLibrary -> {
                    Icons.Default.BookmarkAdded to R.string.remove_from_library
                }
                else -> {
                    Icons.Default.BookmarkAdd to R.string.add_to_library
                }
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = icon,
                    contentDescription = stringResource(contentDescriptionRes),
                )
            }
        },
    )
}

@Composable
private fun ImagePlaceholder(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .placeholder(
                visible = true,
            ),
    )
}

@Composable
@DayNightPreview
private fun BookSearchResultNotInLibraryPreview() {
    val displayModel = BookDisplayModel(
        id = "1",
        title = "Leviathan Wakes",
        author = "James S.A. Corey",
        thumbnailURL = null,
        isInLibrary = false,
    )

    ReaderTheme {
        Surface {
            BookSearchResultListItem(
                displayModel = displayModel,
            )
        }
    }
}

@Composable
@DayNightPreview
private fun BookSearchResultInLibraryPreview() {
    val displayModel = BookDisplayModel(
        id = "1",
        title = "Leviathan Wakes",
        author = "James S.A. Corey",
        thumbnailURL = null,
        isInLibrary = true,
    )

    ReaderTheme {
        Surface {
            BookSearchResultListItem(
                displayModel = displayModel,
            )
        }
    }
}

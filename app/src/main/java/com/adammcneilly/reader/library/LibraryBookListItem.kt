package com.adammcneilly.reader.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.reader.displaymodels.BookDisplayModel
import com.adammcneilly.reader.ui.theme.ReaderTheme

@Composable
fun LibraryBookListItem(
    displayModel: BookDisplayModel,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
    ) {
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
}

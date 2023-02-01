package com.adammcneilly.reader.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adammcneilly.reader.R
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.theme.ReaderTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.search_icon_content_description)
            )
        },
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(
                    onClick = {
                        onValueChange.invoke("")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.clear_text_content_description)
                    )
                }
            }
        },
        placeholder = {
            Text(
                text = stringResource(R.string.search_placeholder)
            )
        },
        shape = CircleShape
    )
}

@Composable
@DayNightPreview
private fun EmptySearchBarPreview() {
    ReaderTheme {
        Surface {
            SearchBar(
                value = "",
                onValueChange = {}
            )
        }
    }
}

@Composable
@DayNightPreview
private fun FilledSearchBarPreview() {
    ReaderTheme {
        Surface {
            SearchBar(
                value = "The Expanse",
                onValueChange = {}
            )
        }
    }
}

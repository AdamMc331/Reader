package com.adammcneilly.reader.ui.components

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adammcneilly.reader.R
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.theme.ReaderTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CenteredReaderTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier.statusBarsPadding(),
            )
        },
    )
}

@Composable
@DayNightPreview
private fun CenteredReaderTopBarPreview() {
    ReaderTheme {
        Surface {
            CenteredReaderTopBar()
        }
    }
}
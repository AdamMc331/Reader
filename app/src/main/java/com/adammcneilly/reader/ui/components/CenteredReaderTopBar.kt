package com.adammcneilly.reader.ui.components

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adammcneilly.reader.R
import com.adammcneilly.reader.displaymodels.TopBarActionDisplayModel
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.TopBarActionType
import com.adammcneilly.reader.ui.theme.ReaderTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CenteredReaderTopBar(
    actionType: TopBarActionType = TopBarActionType.ICON,
    actions: List<TopBarActionDisplayModel> = emptyList(),
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier.statusBarsPadding(),
            )
        },
        actions = {
            actions.forEach { action ->
                TopBarAction(
                    action = action,
                    actionType = actionType,
                    onClick = action.onClick,
                )
            }
        },
    )
}

@Composable
private fun TopBarAction(
    action: TopBarActionDisplayModel,
    actionType: TopBarActionType,
    onClick: () -> Unit,
) {
    when (actionType) {
        TopBarActionType.TEXT -> {
            TextButton(
                onClick = onClick,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = LocalContentColor.current,
                ),
            ) {
                Text(
                    text = stringResource(id = action.textResource),
                )
            }
        }
        TopBarActionType.ICON -> {
            IconButton(
                onClick = onClick,
            ) {
                Icon(
                    imageVector = action.icon,
                    contentDescription = stringResource(id = action.textResource),
                )
            }
        }
    }
}

@Composable
@DayNightPreview
private fun CenteredReaderTopBarIconActionPreview() {
    ReaderTheme {
        Surface {
            CenteredReaderTopBar(
                actionType = TopBarActionType.ICON,
            )
        }
    }
}

@Composable
@DayNightPreview
private fun CenteredReaderTopBarTextActionPreview() {
    ReaderTheme {
        Surface {
            CenteredReaderTopBar(
                actionType = TopBarActionType.TEXT,
            )
        }
    }
}

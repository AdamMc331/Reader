package com.adammcneilly.reader.ui.components

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.adammcneilly.reader.R
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.theme.ReaderTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CenteredReaderTopBar(
    actionType: CenteredReaderTopBar.ActionType = CenteredReaderTopBar.ActionType.Icon,
    actions: List<CenteredReaderTopBar.Action> = listOf(CenteredReaderTopBar.Action.search),
    onActionClicked: (CenteredReaderTopBar.Action) -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier.statusBarsPadding()
            )
        },
        actions = {
            actions.forEach { action ->
                action.Content(
                    actionType = actionType,
                    onClick = {
                        onActionClicked.invoke(action)
                    }
                )
            }
        }
    )
}

object CenteredReaderTopBar {
    enum class ActionType {
        Text,
        Icon
    }

    data class Action(
        val icon: ImageVector,
        val text: String
    ) {

        /**
         * Renders this [Action] as either an [Icon] or [TextButton] based on the supplied [actionType].
         */
        @Composable
        fun Content(
            actionType: ActionType,
            onClick: () -> Unit
        ) {
            when (actionType) {
                ActionType.Text -> {
                    TextButton(
                        onClick = onClick,
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = LocalContentColor.current
                        )
                    ) {
                        Text(
                            text = this@Action.text
                        )
                    }
                }
                ActionType.Icon -> {
                    IconButton(
                        onClick = onClick
                    ) {
                        Icon(
                            imageVector = this.icon,
                            contentDescription = this.text
                        )
                    }
                }
            }
        }

        companion object {
            val search: Action
                @Composable
                get() = Action(
                    icon = Icons.Default.Search,
                    text = stringResource(id = R.string.search)
                )
        }
    }
}

@Composable
@DayNightPreview
private fun CenteredReaderTopBarIconActionPreview() {
    ReaderTheme {
        Surface {
            CenteredReaderTopBar(
                actionType = CenteredReaderTopBar.ActionType.Icon
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
                actionType = CenteredReaderTopBar.ActionType.Text
            )
        }
    }
}

package com.adammcneilly.reader.ui.theme

import android.annotation.TargetApi
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

private val darkColorScheme = darkColorScheme(
    primary = Purple200,
    secondary = Teal200,
)

private val lightColorScheme = lightColorScheme(
    primary = Purple500,
    secondary = Teal200,
)

private val spacing = Spacing(
    verticalListSpacing = 8.dp,
)

@Composable
@TargetApi(Build.VERSION_CODES.S)
fun ReaderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicTheme: Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicTheme && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        dynamicTheme && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }

    CompositionLocalProvider(
        LocalSpacing provides spacing,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object ReaderTheme {
    val spacing: Spacing
        @Composable
        get() = LocalSpacing.current
}

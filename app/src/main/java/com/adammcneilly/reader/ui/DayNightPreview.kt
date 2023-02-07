package com.adammcneilly.reader.ui

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * A custom annotation that combines multiple [Preview] annotations
 * to render a day and night mode preview for components.
 */
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class DayNightPreview

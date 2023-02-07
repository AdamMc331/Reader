package com.adammcneilly.reader.main

import com.adammcneilly.reader.displaymodels.TopBarActionDisplayModel

data class MainActivityViewState(
    val topBarActions: List<TopBarActionDisplayModel> = emptyList(),
)

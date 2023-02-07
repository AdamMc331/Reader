package com.adammcneilly.reader.home

import com.adammcneilly.reader.displaymodels.TopBarActionDisplayModel

data class HomeViewState(
    val topBarActions: List<TopBarActionDisplayModel> = emptyList(),
)

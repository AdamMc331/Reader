package com.adammcneilly.reader.core.ui.components

import com.adammcneilly.reader.BasePaparazziTest
import org.junit.Test

class BottomNavigationBarPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderDefault() {
        snapshot(
            screenPaddingDp = 0,
        ) {
            BottomNavigationBar()
        }
    }
}

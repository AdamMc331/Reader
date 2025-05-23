package com.adammcneilly.reader.core.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.adammcneilly.reader.BasePaparazziTest
import com.adammcneilly.reader.R
import com.adammcneilly.reader.core.displaymodels.AuthorDisplayModel
import com.adammcneilly.reader.core.displaymodels.BookDisplayModel
import com.adammcneilly.reader.core.displaymodels.ImageDisplayModel
import org.junit.Test

class BookOverviewCardPaparazziTest : BasePaparazziTest() {
    private val book = BookDisplayModel(
        id = "123",
        title = "Androids",
        coverImage = ImageDisplayModel.Local(R.drawable.androids),
        author = AuthorDisplayModel(
            id = "123",
            name = "Chet Haase",
            image = ImageDisplayModel.Local(R.drawable.chet),
        ),
    )

    @Test
    fun renderMaxWidth() {
        snapshot {
            BookOverviewCard(
                book = book,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }
}

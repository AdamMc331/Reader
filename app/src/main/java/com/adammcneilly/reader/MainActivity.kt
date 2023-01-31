package com.adammcneilly.reader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.reader.booksearch.BookSearchScreen
import com.adammcneilly.reader.booksearch.BookSearchViewModel
import com.adammcneilly.reader.data.ExpanseBookRepository
import com.adammcneilly.reader.ui.theme.ReaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            ReaderTheme {
                NavHost(
                    navController = navController,
                    startDestination = "search",
                    modifier = Modifier
                        .padding(ReaderTheme.sizing.screenPadding),
                ) {
                    composable("search") {
                        BookSearchScreen(
                            viewModel = BookSearchViewModel(
                                repository = ExpanseBookRepository(),
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ReaderTheme {
        Greeting("Android")
    }
}

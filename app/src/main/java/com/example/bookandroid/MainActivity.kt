package com.example.bookandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.bookandroid.authfeature.domain.usecase.AuthUseCases
import com.example.bookandroid.authfeature.front.forgetpassword.ForgetScreen

import com.example.bookandroid.authfeature.front.signuporin.LoginScreen
import com.example.bookandroid.authfeature.front.signuporin.SignViewModel
import com.example.bookandroid.authfeature.front.theme.BookAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookAndroidTheme {

                // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        ForgetScreen()
                    }

            }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) {
                view , insets ->
                val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
                view.updatePadding(bottom = bottom)
                insets
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BookAndroidTheme {

    }
}
package com.example.bookandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookandroid.authfeature.front.forgetpassword.ForgetScreen
import com.example.bookandroid.authfeature.front.forgetpassword.NewPasswordScreen

import com.example.bookandroid.authfeature.front.signuporin.LoginScreen
import com.example.bookandroid.authfeature.front.signuporin.SignViewModel
import com.example.bookandroid.authfeature.front.theme.BookAndroidTheme
import com.example.bookandroid.authfeature.front.util.Screen
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
                        val navController  = rememberNavController()
                        NavHost(
                            navController=navController,
                            startDestination = Screen.LoginScreen.route
                        ){
                            composable(route = Screen.LoginScreen.route){
                                LoginScreen(navController = navController)
                            }
                            composable(
                                route = Screen.ForgetPassScreen.route
                            ){
                                ForgetScreen(navController = navController)
                            }
                            composable(route = Screen.NewPasswordScreen.route + "?value={value}"
                                , arguments = listOf(
                                    navArgument(name = "value"){
                                        type = NavType.StringType
                                        defaultValue = ""
                                    }
                                )
                            ){
                                NewPasswordScreen(navController = navController )
                            }
                        }
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
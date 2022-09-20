package com.example.bookandroid.authfeature.front.util

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object ForgetPassScreen : Screen("forget_pass_screen")
    object NewPasswordScreen : Screen("new_password")
}
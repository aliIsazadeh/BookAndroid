package com.example.bookandroid.authfeature.domain.usecase


import com.example.bookandroid.authfeature.domain.usecase.signinusecase.SignInEmail
import com.example.bookandroid.authfeature.domain.usecase.signupusecase.SignUpEmail
import com.example.bookandroid.authfeature.domain.usecase.testUsecase.TestApi
import javax.inject.Inject

data class AuthKtorUseCases @Inject constructor(
    val signInEmail: SignInEmail,
//    val OtpEmail: OtpEmail,
    val signUpEmail: SignUpEmail,
    val testService : TestApi

) {
}
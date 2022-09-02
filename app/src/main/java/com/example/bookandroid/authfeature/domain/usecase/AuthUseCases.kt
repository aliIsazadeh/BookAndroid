package com.example.bookandroid.authfeature.domain.usecase

import com.example.bookandroid.authfeature.domain.usecase.signinusecase.SignInEmail
import com.example.bookandroid.authfeature.domain.usecase.signinusecase.SignInPhoneNumber
import com.example.bookandroid.authfeature.domain.usecase.signinusecase.SignInUsername
import com.example.bookandroid.authfeature.domain.usecase.signupusecase.SignUpEmail
import com.example.bookandroid.authfeature.domain.usecase.signupusecase.SignUpPhoneNumber
import dagger.Provides
import javax.inject.Inject


data class AuthUseCases @Inject constructor(
    val signInEmail: SignInEmail,
    val signInUsername: SignInUsername,
    val signInPhoneNumber: SignInPhoneNumber,
    val signUpEmail: SignUpEmail,
    val signUpPhoneNumber: SignUpPhoneNumber,

)

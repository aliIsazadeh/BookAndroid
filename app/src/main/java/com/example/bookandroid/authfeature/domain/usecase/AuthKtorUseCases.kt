package com.example.bookandroid.authfeature.domain.usecase

import com.example.bookandroid.authfeature.domain.usecase.forgetpassword.OtpEmail
import com.example.bookandroid.authfeature.domain.usecase.forgetpassword.OtpPhoneNumber
import com.example.bookandroid.authfeature.domain.usecase.signinusecase.SignInEmail
import javax.inject.Inject

data class AuthKtorUseCases @Inject constructor(
    val signInEmail: SignInEmail,
//    val OtpEmail: OtpEmail,
    val otpPhoneNumber : OtpPhoneNumber

) {
}
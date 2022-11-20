package com.example.bookandroid.authfeature.data.remote.services


import com.example.bookandroid.authfeature.data.remote.services.otpservice.TestService
import com.example.bookandroid.authfeature.data.remote.services.signinservice.SignInService
import com.example.bookandroid.authfeature.data.remote.services.signup.SignUpEmailService

class ServiceFactory(
    val signInService: SignInService,
    val singUpEmailService: SignUpEmailService,
    val testService: TestService
)
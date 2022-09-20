package com.example.bookandroid.authfeature.data.remote.services

import com.example.bookandroid.authfeature.data.remote.services.otpservice.GetOtpService
import com.example.bookandroid.authfeature.data.remote.services.signinservice.SignInService

class ServiceFactory(
    val signInService: SignInService,
    val getOtpService: GetOtpService
)
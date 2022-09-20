package com.example.bookandroid.authfeature.domain.repository

import com.example.bookandroid.authfeature.data.remote.dto.SignInResponse.SignInResponse
import com.example.bookandroid.authfeature.data.remote.dto.otp.OtpResponse
import com.example.bookandroid.authfeature.domain.model.SignUser

interface AuthKtorRepository {
    suspend fun signInEmail(user : SignUser): SignInResponse?

    suspend fun getOtp(phoneNumber: String): OtpResponse?
}
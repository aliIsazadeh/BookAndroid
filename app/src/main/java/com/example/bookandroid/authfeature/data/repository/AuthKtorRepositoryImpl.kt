package com.example.bookandroid.authfeature.data.repository

import com.example.bookandroid.authfeature.data.remote.dto.signinrequests.SignInRequestEmail
import com.example.bookandroid.authfeature.data.remote.dto.SignInResponse.SignInResponse
import com.example.bookandroid.authfeature.data.remote.dto.otp.OtpResponse
import com.example.bookandroid.authfeature.data.remote.services.ServiceFactory
import com.example.bookandroid.authfeature.domain.model.SignUser
import com.example.bookandroid.authfeature.domain.repository.AuthKtorRepository

class AuthKtorRepositoryImpl(private val authServiceFactory: ServiceFactory) : AuthKtorRepository {
    override suspend fun signInEmail(user: SignUser): SignInResponse? =
        authServiceFactory.signInService.signInEmail(
            SignInRequestEmail(
                email = user.email,
                password = user.passwordAuthentication
            )
        )

    override suspend fun getOtp(phoneNumber: String): OtpResponse? {
        return authServiceFactory.getOtpService.getOtp(phoneNumber)
    }
}
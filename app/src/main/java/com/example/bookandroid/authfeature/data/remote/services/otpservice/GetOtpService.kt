package com.example.bookandroid.authfeature.data.remote.services.otpservice

import com.example.bookandroid.authfeature.data.remote.dto.otp.OtpResponse
import com.example.bookandroid.authfeature.domain.usecase.forgetpassword.OtpPhoneNumber

interface GetOtpService {
    suspend fun getOtp(phoneNumber: String): OtpResponse
}
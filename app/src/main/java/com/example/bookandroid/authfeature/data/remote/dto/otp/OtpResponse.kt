package com.example.bookandroid.authfeature.data.remote.dto.otp

import kotlinx.serialization.Serializable


@Serializable
data class OtpResponse(var expireDate: String ,  var otpKey : String)

package com.example.bookandroid.authfeature.data.remote.dto.signin.signinrequests

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequestEmail(
    var email  : String,
    var password: String
)
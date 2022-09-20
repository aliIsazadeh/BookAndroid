package com.example.bookandroid.authfeature.data.remote.dto.SignInResponse

import com.example.bookandroid.authfeature.data.remote.dto.User
import kotlinx.serialization.Serializable

@Serializable
data class SignInResponse(
    var statusCode : Int,

    var authToken: String,

    var user: User

)
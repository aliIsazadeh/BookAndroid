package com.example.bookandroid.authfeature.data.remote.dto.signup

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SignUpParams(
    @SerialName("username")
    val username: String = "",
    @SerialName("email")
    val email : String = "",
    @SerialName("phoneNumber")
    val phoneNumber :String = "",
    @SerialName("password")
    val password : String = ""
)
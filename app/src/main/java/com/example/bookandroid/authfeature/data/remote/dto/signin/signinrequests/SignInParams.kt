package com.example.bookandroid.authfeature.data.remote.dto.signin.signinrequests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignInParams(

    val username: String = "",

    val email : String = "",

    val phoneNumber :String = "",

    val password : String = ""
)
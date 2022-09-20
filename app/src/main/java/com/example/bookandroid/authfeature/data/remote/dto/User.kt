package com.example.bookandroid.authfeature.data.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class User(
    var email : String ,
    var phone_number: String,
    var username : String,
    var password : String,
)
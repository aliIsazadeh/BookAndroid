package com.example.bookandroid.authfeature.domain.model

data class SignUpResponse (
    val fullName : String? =null ,
    val userName : String? =null,
    val email : String? =null,
    val avatar : String? =null,
    val password : String? =null,
    var authToken : String? = null,
    val createAt : String? =null,
    val errorMessage : String? = null
        )
package com.example.bookandroid.authfeature.data.remote.dto.signup

import kotlinx.serialization.Serializable

@Serializable
data class SignUpResponseDto(
    val data : Data? = null,
    val error: Error? = null
){
    @Serializable
    data class Data(
        val user: User
    ){
        @Serializable
        data class User(
            val id : Int,
            val fullName : String? =null ,
            val userName : String? =null,
            val email : String? =null,
            val avatar : String? =null,
            val password : String? =null,
            var authToken : String? = null,
            val createAt : String? =null
        )
    }

    @Serializable
    data class Error(
        val message: String?= null
    )
}
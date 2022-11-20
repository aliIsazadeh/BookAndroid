package com.example.bookandroid.authfeature.data.remote.dto.test

import kotlinx.serialization.Serializable

@Serializable
data class TestResponseDto(
    val data : Data? = null,
    val error: Error? = null
){
    @Serializable
    data class Data(
        val text : String
    )

    @Serializable
    data class Error(
        val message: String?= null
    )
}
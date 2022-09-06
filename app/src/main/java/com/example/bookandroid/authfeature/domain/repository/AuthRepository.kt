package com.example.bookandroid.authfeature.domain.repository

import com.example.bookandroid.authfeature.domain.model.SignUser

interface AuthRepository {

    suspend fun signInEmail(user : SignUser): Any?

    suspend fun signUpPhoneNumber(user : SignUser): Any?

    suspend fun signInUsername(user : SignUser): Any?


    suspend fun signInPhoneNumber(user : SignUser): Any?

    suspend fun signUpEmail(user : SignUser): Any?

    suspend fun forgetPasswordEmail(email : String) : Any?

    suspend fun forgetPasswordPhoneNumber(phoneNumber : String) : Any?

}
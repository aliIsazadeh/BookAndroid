package com.example.bookandroid.authfeature.domain.repository

import com.example.bookandroid.authfeature.domain.model.SignUser

interface AuthRepository {

    suspend fun signInEmail(user : SignUser): Any?

    suspend fun signUpPhoneNumber(user : SignUser): Any?

    suspend fun signInUsername(user : SignUser): Any?


    suspend fun signInPhoneNumber(user : SignUser): Any?

    suspend fun signUpEmail(user : SignUser): Any?

    suspend fun forgetPasswordEmail(email : String, password: String) : Any?

    suspend fun forgetPasswordPhoneNumber(phoneNumber : String , password: String) : Any?

    suspend fun isUsernameAvailable(username : String) : Boolean?

    suspend fun otpCodeEmail(email :String) : Any?

    suspend fun otpCodePhoneNumber(phoneNumber: String): Any?



}
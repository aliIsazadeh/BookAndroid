package com.example.bookandroid.authfeature.data.remote.services.signinservice

import com.example.bookandroid.authfeature.data.remote.dto.signinrequests.SignInRequestEmail
import com.example.bookandroid.authfeature.data.remote.dto.SignInResponse.SignInResponse

interface SignInService {

    suspend fun signInEmail(request : SignInRequestEmail) : SignInResponse?
}
package com.example.bookandroid.authfeature.data.remote.services.signinservice

import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.data.remote.dto.signin.signinrequests.SignInRequestEmail
import com.example.bookandroid.authfeature.data.remote.dto.signin.SignInResponse.SignInResponse
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpResponseDto


interface SignInService {

    suspend fun signInEmail(request : SignInRequestEmail) : Resource<SignUpResponseDto>?
}
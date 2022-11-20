package com.example.bookandroid.authfeature.domain.repository

import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.data.remote.dto.signin.SignInResponse.SignInResponse
import com.example.bookandroid.authfeature.data.remote.dto.signin.signinrequests.SignInRequestEmail
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpParams
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpResponseDto
import com.example.bookandroid.authfeature.data.remote.dto.test.TestResponseDto
import com.example.bookandroid.authfeature.data.remote.services.otpservice.TestServiceImpl
import com.example.bookandroid.authfeature.domain.model.SignUser
import kotlinx.coroutines.flow.Flow

interface AuthKtorRepository {
    suspend fun signInEmail(params : SignInRequestEmail): Flow<Resource<SignUpResponseDto>>



    suspend fun signUpEmail(params: SignUpParams) : Flow<Resource<SignUpResponseDto>>

    suspend fun testApi() : Flow<Resource<TestResponseDto>>
}
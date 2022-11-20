package com.example.bookandroid.authfeature.data.remote.services.signup

import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpParams
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpResponseDto

interface SignUpEmailService {
    suspend fun signUpByEmail(params: SignUpParams): Resource<SignUpResponseDto>?
}
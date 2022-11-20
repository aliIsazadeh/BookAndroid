package com.example.bookandroid.authfeature.data.remote.services.otpservice

import com.example.bookandroid.authfeature.common.Resource

import com.example.bookandroid.authfeature.data.remote.dto.test.TestResponseDto


interface TestService {
    suspend fun testApi(): Resource<TestResponseDto>?
}
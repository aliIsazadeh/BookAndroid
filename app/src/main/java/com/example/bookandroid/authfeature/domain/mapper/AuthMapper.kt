package com.example.bookandroid.authfeature.domain.mapper

import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpResponseDto
import com.example.bookandroid.authfeature.data.remote.dto.test.TestResponseDto
import com.example.bookandroid.authfeature.domain.model.SignUpResponse
import com.example.bookandroid.authfeature.domain.model.TestServiceResponse

fun SignUpResponseDto.toSignUpResponse() = SignUpResponse(
    fullName = data?.user?.fullName,
    userName = data?.user?.userName,
    email = data?.user?.email,
    avatar = data?.user?.avatar,
    password = data?.user?.password,
    authToken = data?.user?.authToken,
    createAt = data?.user?.createAt,
    errorMessage = error?.message
)

fun TestResponseDto.toTestResponse() = TestServiceResponse(
    response = data?.text,
    errorMessage = error?.message
)
package com.example.bookandroid.authfeature.data.repository

import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.data.remote.dto.signin.signinrequests.SignInRequestEmail
import com.example.bookandroid.authfeature.data.remote.dto.signin.SignInResponse.SignInResponse
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpParams
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpResponseDto
import com.example.bookandroid.authfeature.data.remote.dto.test.TestResponseDto
import com.example.bookandroid.authfeature.data.remote.services.ServiceFactory
import com.example.bookandroid.authfeature.domain.model.SignUser
import com.example.bookandroid.authfeature.domain.repository.AuthKtorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthKtorRepositoryImpl(private val authServiceFactory: ServiceFactory) : AuthKtorRepository {
    override suspend fun signInEmail(params : SignInRequestEmail): Flow<Resource<SignUpResponseDto>> =
        flow {
            when (val response = authServiceFactory.signInService.signInEmail(params)) {
                is Resource.Error -> emit(Resource.error(response.message))
                is Resource.Success -> emit(Resource.success(response.data))
                else -> emit(Resource.error("i get nothing"))

            }
        } as Flow<Resource<SignUpResponseDto>>



    override suspend fun signUpEmail(params: SignUpParams): Flow<Resource<SignUpResponseDto>> =
        flow {
            when (val response = authServiceFactory.singUpEmailService.signUpByEmail(params)) {
                is Resource.Error -> emit(Resource.error(response.message))
                is Resource.Success -> emit(Resource.success(response.data))
                else -> emit(Resource.error("i get nothing"))
            }
        } as Flow<Resource<SignUpResponseDto>>

    override suspend fun testApi(): Flow<Resource<TestResponseDto>> =
        flow {
            when (val response = authServiceFactory.testService.testApi()) {
                is Resource.Error -> emit(Resource.error(response.message))
                is Resource.Success -> emit(Resource.success(response.data))
                else -> emit(Resource.error("i get nothing"))
            }
        } as Flow<Resource<TestResponseDto>>





}
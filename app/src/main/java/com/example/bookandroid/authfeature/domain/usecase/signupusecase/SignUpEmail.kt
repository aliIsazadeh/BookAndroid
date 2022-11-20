package com.example.bookandroid.authfeature.domain.usecase.signupusecase

import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpParams
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpResponseDto
import com.example.bookandroid.authfeature.domain.model.SignUpResponse
import com.example.bookandroid.authfeature.domain.model.SignUser
import com.example.bookandroid.authfeature.domain.repository.AuthKtorRepository
import com.example.bookandroid.authfeature.domain.repository.AuthRepository
import com.example.bookandroid.authfeature.domain.mapper.toSignUpResponse

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignUpEmail @Inject constructor(
    private val repository: AuthKtorRepository
) {

    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke(params: SignUpParams) : Flow<Resource<SignUpResponse>> = flow {

        repository.signUpEmail(params).collect {
            when (it) {
                is Resource.Error -> emit(Resource.error(it.message.toSignUpResponse()))
                is Resource.Success -> emit(Resource.success(it.data.toSignUpResponse()))
                else -> Resource.error("i got nothing")
            }
        }

    }

}
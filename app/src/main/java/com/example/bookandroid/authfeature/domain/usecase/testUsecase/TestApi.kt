package com.example.bookandroid.authfeature.domain.usecase.testUsecase

import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpParams
import com.example.bookandroid.authfeature.data.remote.dto.test.TestResponseDto
import com.example.bookandroid.authfeature.domain.mapper.toSignUpResponse
import com.example.bookandroid.authfeature.domain.mapper.toTestResponse
import com.example.bookandroid.authfeature.domain.model.SignUpResponse
import com.example.bookandroid.authfeature.domain.model.TestServiceResponse
import com.example.bookandroid.authfeature.domain.repository.AuthKtorRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TestApi @Inject constructor(private val repository: AuthKtorRepository)
{

    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke() : Flow<Resource<TestServiceResponse>> = flow {

        repository.testApi().collect {
            when (it) {
                is Resource.Error -> emit(Resource.error(it.message.toTestResponse()))
                is Resource.Success -> emit(Resource.success(it.data.toTestResponse()))
                else -> Resource.error("i got nothing")
            }
        }

    }

}
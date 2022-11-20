package com.example.bookandroid.authfeature.data.remote.services.otpservice

import android.util.Log
import com.example.bookandroid.authfeature.common.Constants
import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.data.remote.dto.signin.signinrequests.SignInRequestEmail
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpParams
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpResponseDto
import com.example.bookandroid.authfeature.data.remote.dto.test.TestResponseDto
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.io.IOException

class TestServiceImpl(private val client: HttpClient) : TestService {
    override suspend fun testApi(): Resource<TestResponseDto> =
        try {


//            val response = client.post<SignUpResponseDto>(url = Constants.REGISTER_BY_EMAIL_URL   ) {
//                contentType(ContentType.Application.Json)
//                body = params
//            }
            val response : TestResponseDto = client.get(Constants.TEST_API){

                contentType(ContentType.Application.Json)
            }as TestResponseDto

            when (response.data) {
                null -> Resource.error(response)
                else -> Resource.success(response)
            }


        } catch (e: Exception) {
            Resource.error(TestResponseDto(error = TestResponseDto.Error(e.message)))
        }
}
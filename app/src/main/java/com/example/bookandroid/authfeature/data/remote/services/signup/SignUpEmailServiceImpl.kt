package com.example.bookandroid.authfeature.data.remote.services.signup

import com.example.bookandroid.authfeature.common.Constants
import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpParams
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpResponseDto
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import java.io.IOException
import com.google.gson.Gson

class SignUpEmailServiceImpl(private val client: HttpClient) : SignUpEmailService {
    override suspend fun signUpByEmail(params: SignUpParams): Resource<SignUpResponseDto> =
        try {


//            val response = client.post<SignUpResponseDto>(url = Constants.REGISTER_BY_EMAIL_URL   ) {
//                contentType(ContentType.Application.Json)
//                body = params
//            }
            val response : SignUpResponseDto = client.post(Constants.REGISTER_BY_EMAIL_URL){
                setBody(params)
                contentType(ContentType.Application.Json)
            }as SignUpResponseDto

            when (response.data) {
                null -> Resource.error(response)
                else -> Resource.success(response)
            }


        } catch (e: Exception) {
            Resource.error(SignUpResponseDto(error = SignUpResponseDto.Error(e.message)))
        }

}
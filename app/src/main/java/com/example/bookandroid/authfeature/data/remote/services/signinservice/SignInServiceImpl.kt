package com.example.bookandroid.authfeature.data.remote.services.signinservice

import com.example.bookandroid.authfeature.common.Constants
import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.data.remote.dto.signin.signinrequests.SignInRequestEmail
import com.example.bookandroid.authfeature.data.remote.dto.signin.SignInResponse.SignInResponse
import com.example.bookandroid.authfeature.data.remote.dto.signup.SignUpResponseDto
import io.ktor.client.*
import io.ktor.client.plugins.*
//import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.io.IOException

class SignInServiceImpl(
    private val client : HttpClient
) : SignInService {
    override suspend fun signInEmail(request: SignInRequestEmail): Resource<SignUpResponseDto> =
         try {

            val response : SignUpResponseDto = client.post(Constants.REGISTER_BY_EMAIL_URL){
                setBody(request)
                contentType(ContentType.Application.Json)
            }as SignUpResponseDto

            when (response.data) {
                null -> Resource.error(response)
                else -> Resource.success(response)
            }
        }catch (e: RedirectResponseException) {
            throw Exception("Further action needs to be taken in order to complete the request")
        } catch (e: ClientRequestException) {
            throw Exception("The request contains bad syntax or cannot be fulfilled")
        } catch (e: ServerResponseException) {
            throw Exception("The server failed to fulfil an apparently valid request")
        } catch (e: IOException) {
            throw Exception("No internet connection")
        } catch (e: Exception) {
            throw Exception(" Unknown error occurred")
        }

}
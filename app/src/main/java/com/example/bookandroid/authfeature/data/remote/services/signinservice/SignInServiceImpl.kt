package com.example.bookandroid.authfeature.data.remote.services.signinservice

import com.example.bookandroid.authfeature.common.Constants
import com.example.bookandroid.authfeature.data.remote.dto.signinrequests.SignInRequestEmail
import com.example.bookandroid.authfeature.data.remote.dto.SignInResponse.SignInResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.io.IOException

class SignInServiceImpl(
    private val client : HttpClient
) : SignInService {
    override suspend fun signInEmail(request: SignInRequestEmail): SignInResponse? {
        return try {
            client.post<SignInResponse>(){
                url(Constants.EMAIL_SIGN_IN_URL)
                contentType(ContentType.Application.Json)
                body = request
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
}
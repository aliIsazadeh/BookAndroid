package com.example.bookandroid.authfeature.data.remote.services.otpservice

import com.example.bookandroid.authfeature.common.Constants
import com.example.bookandroid.authfeature.data.remote.dto.otp.OtpResponse
import com.example.bookandroid.authfeature.data.remote.dto.signinrequests.SignInRequestEmail
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import java.io.IOException

class GetOtpServiceImpl(private val client: HttpClient) : GetOtpService {
    override suspend fun getOtp(phoneNumber: String): OtpResponse {
        return try {
            client.get{
                url(Constants.BASE_URL+"/"+Constants.SITE_ID+"/"+"phoneNumber="+phoneNumber)
                body = SignInRequestEmail(email = "test@test.com" , password = "test")
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
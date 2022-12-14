package com.example.bookandroid.authfeature.data

import android.provider.ContactsContract
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApi {

    @POST("")
    suspend fun signInWithEmail(
        @Path(value = "email") email: String,
        @Path(value = "password") password: String
    ): Any?

    @POST("")
    suspend fun signInWithPhoneNumber(
        @Path(value = "phoneNumber") phoneNumber: String,
        @Path(value = "password") password: String
    ): Any?

    @POST("")
    suspend fun signInWithUsername(
        @Path(value = "Username") userName: String,
        @Path(value = "password") password: String
    ): Any?

    @POST("")
    suspend fun signUpWithEmail(
        @Path(value = "email") email: String,
        @Path(value = "password") password: String
    ): Any?

    @POST("")
    suspend fun signUpWithPhoneNumber(
        @Path(value = "phoneNumber") phoneNumber: String,
        @Path(value = "password") password: String
    ): Any?

    @POST("")
    fun forgetPasswordEmail(@Path(value = "email") email: String): Any?

    @POST("")
    fun forgetPasswordPhoneNumber(@Path(value = "phoneNumber") phoneNumber: String): Any?

    @GET("")
    fun isUsernameAvailable(@Path(value = "username") userName: String): Boolean?

    @GET("")
    suspend fun otpEmail(@Path(value = "email") email: String): Any?

    @GET("")
    suspend fun otpPhoneNumber(@Path(value = "phoneNumber") phoneNumber: String): Any?


}
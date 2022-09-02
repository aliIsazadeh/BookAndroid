package com.example.bookandroid.authfeature.data

import android.provider.ContactsContract
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApi {

    @POST("")
    suspend fun signInWithEmail(@Path(value = "email") email: String , @Path(value = "password") password : String) : Any?

    @POST("")
    suspend fun signInWithPhoneNumber(@Path(value = "phoneNumber") phoneNumber: String , @Path(value = "password") password : String) : Any?

    @POST("")
    suspend fun signInWithUsername(@Path(value = "Username" ) userName : String , @Path(value = "password") password : String) : Any?

    @POST("")
    suspend fun signUpWithEmail(@Path(value = "email") email: String , @Path(value = "password") password : String) : Any?

    @POST("")
    suspend fun signUpWithPhoneNumber(@Path(value = "phoneNumber") phoneNumber: String , @Path(value = "password") password : String) : Any?







}
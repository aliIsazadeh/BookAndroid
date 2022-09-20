package com.example.bookandroid.authfeature.data.repository

import android.text.BoringLayout
import com.example.bookandroid.authfeature.data.AuthApi
import com.example.bookandroid.authfeature.domain.model.SignUser
import com.example.bookandroid.authfeature.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
) : AuthRepository{
    override suspend fun signInEmail(user: SignUser): Any? {
        return api.signInWithEmail(email = user.email, password = user.passwordAuthentication )
    }

    override suspend fun signUpPhoneNumber(user: SignUser): Any? {
        return api.signInWithPhoneNumber(phoneNumber = user.phoneNumber , password = user.passwordAuthentication )
    }

    override suspend fun signInUsername(user: SignUser): Any? {
        return api.signInWithUsername(userName = user.username , password = user.passwordAuthentication )
    }

    override suspend fun signInPhoneNumber(user: SignUser): Any? {
        return api.signUpWithPhoneNumber(phoneNumber = user.phoneNumber , password = user.passwordAuthentication )
    }

    override suspend fun signUpEmail(user: SignUser): Any? {
        return api.signUpWithEmail(email = user.email, password = user.passwordAuthentication )
    }

    override suspend fun forgetPasswordEmail(email: String , password: String): Any? {
        return api.forgetPasswordEmail(email = email , password = password)
    }

    override suspend fun forgetPasswordPhoneNumber(phoneNumber: String , password: String): Any? {
        return api.forgetPasswordPhoneNumber(phoneNumber = phoneNumber , password = password)
    }

    override suspend fun isUsernameAvailable(username: String) : Boolean? {
        return api.isUsernameAvailable(userName = username)

    }

    override suspend fun otpCodeEmail(email: String): Any? {
        return api.otpEmail(email= email)
    }

    override suspend fun otpCodePhoneNumber(phoneNumber: String): Any? {
        return api.otpPhoneNumber(phoneNumber = phoneNumber)
    }




}
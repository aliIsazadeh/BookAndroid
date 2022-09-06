package com.example.bookandroid.authfeature.data.repository

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

    override suspend fun forgetPasswordEmail(email: String): Any? {
        return api.forgetPasswordEmail(email = email)
    }

    override suspend fun forgetPasswordPhoneNumber(phoneNumber: String): Any? {
        return api.forgetPasswordPhoneNumber(phoneNumber = phoneNumber)
    }


}
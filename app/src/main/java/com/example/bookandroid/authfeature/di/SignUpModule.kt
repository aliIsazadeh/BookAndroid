package com.example.bookandroid.authfeature.di

import com.example.bookandroid.authfeature.data.remote.services.signinservice.SignInService
import com.example.bookandroid.authfeature.data.remote.services.signinservice.SignInServiceImpl
import com.example.bookandroid.authfeature.data.remote.services.signup.SignUpEmailService
import com.example.bookandroid.authfeature.data.remote.services.signup.SignUpEmailServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SignUpModule {

    @Provides
    @Singleton
    fun provideSignUpInstance(customClient: HttpClient): SignUpEmailService {
        return SignUpEmailServiceImpl(
            client = customClient
        )
    }
}
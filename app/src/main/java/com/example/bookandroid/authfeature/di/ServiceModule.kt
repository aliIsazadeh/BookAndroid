package com.example.bookandroid.authfeature.di

import com.example.bookandroid.authfeature.data.remote.services.ServiceFactory

import com.example.bookandroid.authfeature.data.remote.services.otpservice.TestService
import com.example.bookandroid.authfeature.data.remote.services.signinservice.SignInService
import com.example.bookandroid.authfeature.data.remote.services.signup.SignUpEmailService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {


    @Provides
    @Singleton
    fun provideServiceFactory(
        signInService: SignInService,
        signUpEmailService: SignUpEmailService,
        testService: TestService
    ): ServiceFactory{
        return ServiceFactory(
            signInService,
            signUpEmailService,
            testService
        )
    }

}
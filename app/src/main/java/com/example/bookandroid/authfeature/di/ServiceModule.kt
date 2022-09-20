package com.example.bookandroid.authfeature.di

import com.example.bookandroid.authfeature.data.remote.services.ServiceFactory
import com.example.bookandroid.authfeature.data.remote.services.otpservice.GetOtpService
import com.example.bookandroid.authfeature.data.remote.services.signinservice.SignInService
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
        otpService: GetOtpService
    ): ServiceFactory{
        return ServiceFactory(
            signInService,
            otpService
        )
    }

}
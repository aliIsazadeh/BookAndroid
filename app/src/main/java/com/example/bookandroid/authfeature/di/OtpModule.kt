package com.example.bookandroid.authfeature.di

import com.example.bookandroid.authfeature.data.remote.services.otpservice.GetOtpService
import com.example.bookandroid.authfeature.data.remote.services.otpservice.GetOtpServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OtpModule {

    @Provides
    @Singleton
    fun provideOtpEmailInstance(customClient: HttpClient) : GetOtpService{
        return GetOtpServiceImpl(
            client = customClient
        )
    }

//    @Provides
//    @Singleton
//    fun provideOtpInstance(customClient: HttpClient) : GetOtpService{
//        return GetOtpServiceImpl(
//            client = customClient
//        )
//    }

}
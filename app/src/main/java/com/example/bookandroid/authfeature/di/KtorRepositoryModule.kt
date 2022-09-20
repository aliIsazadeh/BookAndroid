package com.example.bookandroid.authfeature.di

import com.example.bookandroid.authfeature.data.remote.services.ServiceFactory
import com.example.bookandroid.authfeature.data.repository.AuthKtorRepositoryImpl
import com.example.bookandroid.authfeature.data.repository.AuthRepositoryImpl
import com.example.bookandroid.authfeature.domain.repository.AuthKtorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object KtorRepositoryModule {

    @Provides
    @Singleton
    fun provideAuthKtorRepository(
        serviceFactory: ServiceFactory
    ): AuthKtorRepository{
        return AuthKtorRepositoryImpl(authServiceFactory = serviceFactory)
    }

}
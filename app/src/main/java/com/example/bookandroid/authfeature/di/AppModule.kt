package com.example.bookandroid.authfeature.di

import com.example.bookandroid.authfeature.common.Constants
import com.example.bookandroid.authfeature.data.AuthApi
import com.example.bookandroid.authfeature.data.repository.AuthRepositoryImpl
import com.example.bookandroid.authfeature.domain.repository.AuthKtorRepository
import com.example.bookandroid.authfeature.domain.repository.AuthRepository
import com.example.bookandroid.authfeature.domain.usecase.AuthKtorUseCases
import com.example.bookandroid.authfeature.domain.usecase.AuthUseCases
import com.example.bookandroid.authfeature.domain.usecase.newpassword.ForgetPasswordEmail
import com.example.bookandroid.authfeature.domain.usecase.newpassword.ForgetPasswordPhoneNumber
import com.example.bookandroid.authfeature.domain.usecase.forgetpassword.OtpEmail
import com.example.bookandroid.authfeature.domain.usecase.forgetpassword.OtpPhoneNumber
import com.example.bookandroid.authfeature.domain.usecase.signinusecase.SignInEmail
import com.example.bookandroid.authfeature.domain.usecase.signinusecase.SignInPhoneNumber
import com.example.bookandroid.authfeature.domain.usecase.signinusecase.SignInUsername
import com.example.bookandroid.authfeature.domain.usecase.signupusecase.IsUsernameAvailable
import com.example.bookandroid.authfeature.domain.usecase.signupusecase.SignUpEmail
import com.example.bookandroid.authfeature.domain.usecase.signupusecase.SignUpPhoneNumber
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideAuthApi(): AuthApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthApi): AuthRepository{
        return AuthRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideAuthUseCases(repository: AuthRepository) : AuthUseCases{
        return AuthUseCases(
//            signInEmail = SignInEmail(repository),
            signInPhoneNumber = SignInPhoneNumber(repository),
            signInUsername = SignInUsername(repository),

            signUpEmail = SignUpEmail(repository),
            signUpPhoneNumber = SignUpPhoneNumber(repository),

            forgetPasswordEmail = ForgetPasswordEmail(repository),
            forgetPasswordPhoneNumber = ForgetPasswordPhoneNumber(repository),

            isUsernameAvailable = IsUsernameAvailable(repository),

//            otpEmail = OtpEmail(repository),
//            otpPhoneNumber = OtpPhoneNumber(repository)

        )
    }

    @Provides
    @Singleton
    fun provideAuthKtorUseCases(repository: AuthKtorRepository) : AuthKtorUseCases {
        return AuthKtorUseCases(
            signInEmail = SignInEmail(repository),
//            signInPhoneNumber = SignInPhoneNumber(repository),
//            signInUsername = SignInUsername(repository),
//
//            signUpEmail = SignUpEmail(repository),
//            signUpPhoneNumber = SignUpPhoneNumber(repository),
//
//            forgetPasswordEmail = ForgetPasswordEmail(repository),
//            forgetPasswordPhoneNumber = ForgetPasswordPhoneNumber(repository),
//
//            isUsernameAvailable = IsUsernameAvailable(repository),

//            otpEmail = OtpEmail(repository),
            otpPhoneNumber = OtpPhoneNumber(repository),
//            OtpEmail =

        )
    }




}
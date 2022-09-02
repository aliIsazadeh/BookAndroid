package com.example.bookandroid.authfeature.domain.usecase.signupusecase

import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.domain.model.SignUser
import com.example.bookandroid.authfeature.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignUpPhoneNumber @Inject constructor(
    private val repository: AuthRepository
) {

    operator fun invoke(user: SignUser) : Flow<Resource<Any>> = channelFlow {

        try {
            send(Resource.Loading<Any>())
            val response = repository.signUpPhoneNumber(user)
            send(Resource.Success<Any>(response as Any))
        }catch (e : HttpException){
            send(Resource.Error<Any>(e.localizedMessage ?: "An unexpected error occurred"))
        }
        catch (e : IOException){
            send(Resource.Error<Any>("Couldn't reach server. Check your internet Connection"))
        }

    }

}
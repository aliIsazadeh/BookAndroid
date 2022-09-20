package com.example.bookandroid.authfeature.domain.usecase.newpassword

import com.example.bookandroid.authfeature.common.Resource
import com.example.bookandroid.authfeature.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ForgetPasswordPhoneNumber @Inject constructor(
    private val repository: AuthRepository
) {



    operator fun invoke(phoneNumber :String , password : String) : Flow<Resource<Any>> = channelFlow {
        try {
            send(Resource.Loading<Any>())
            val response = repository.forgetPasswordPhoneNumber(phoneNumber , password )
            send(Resource.Success<Any>(response as Any))
        }catch (e : HttpException){
            send(Resource.Error<Any>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e : IOException){
            send(Resource.Error<Any>("Couldn't reach server. Check your internet Connection"))
        }
    }
}
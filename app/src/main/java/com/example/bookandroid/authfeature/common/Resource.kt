package com.example.bookandroid.authfeature.common

sealed class Resource<T>{

    class Success <T>(val data: T ):Resource<T> ()
    class Error<T> (val message: T ) : Resource<T>()
    class Loading<T>() : Resource<T>()

    companion object {
        fun <T> success(data: T) = Success<T>(data)
        fun <T> error(message: T) = Error<T>(message)



    }
}

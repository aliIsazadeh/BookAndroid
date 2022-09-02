package com.example.bookandroid.authfeature.domain.model

import android.provider.ContactsContract
import androidx.room.Entity

@Entity
data class SignUser (
    val username : String,
    val phoneNumber: String,
    val email: String,
    val passwordAuthentication: String,
)

class InvalidUserException(message : String): Exception(message)
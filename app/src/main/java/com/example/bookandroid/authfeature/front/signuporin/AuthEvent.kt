package com.example.bookandroid.authfeature.front.signuporin

import androidx.compose.ui.focus.FocusState
import com.example.bookandroid.authfeature.domain.model.SignUser

sealed class AuthEvent {
    data class ShowSnackBar(val message : String) : AuthEvent()
    data class SignIn(val signUser: SignUser) : AuthEvent()
    data class SignUp(val signUser: SignUser) : AuthEvent()
    object IsSignIn : AuthEvent()
    object IsSignUp : AuthEvent()

    data class EnteredValueSignIn(val value: String) : AuthEvent()
    data class EnteredPasswordSignIn(val value: String) : AuthEvent()


    data class ChangeFocusValueSignIn(val focusState: FocusState) : AuthEvent()
    data class ChangeFocusPasswordSignIn(val focusState: FocusState) : AuthEvent()


    data class EnteredValueSignUp(val value: String) : AuthEvent()
    data class EnteredPasswordSignUp(val value: String) : AuthEvent()
    data class EnteredPasswordConfirmSignUp(val value: String) : AuthEvent()


    data class ChangeFocusValueSignUp(val focusState: FocusState) : AuthEvent()
    data class ChangeFocusPasswordSignUp(val focusState: FocusState) : AuthEvent()
    data class ChangeFocusPasswordConfirmSignUp(val focusState: FocusState) : AuthEvent()



}

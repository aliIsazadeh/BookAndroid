package com.example.bookandroid.authfeature.front.newpassword

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.VpnKey
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bookandroid.R
import com.example.bookandroid.authfeature.domain.usecase.AuthUseCases
import com.example.bookandroid.authfeature.front.signuporin.AuthEvent
import com.example.bookandroid.authfeature.front.signuporin.SignSubmitState
import com.example.bookandroid.authfeature.front.signuporin.TextFieldState
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NewPasswordViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    @SuppressLint("StaticFieldLeak") @ApplicationContext private val application: Context
): ViewModel(){

    private val _isKeyBoardOpen: State<Boolean> = mutableStateOf(
        value = false
    )

    var isKeyBoardOpen: State<Boolean> = _isKeyBoardOpen


    private val _newPassword = mutableStateOf(
        TextFieldState(
            hint = application.getString(R.string.new_password),
            icon = Icons.Default.VerifiedUser
        )
    )
    val newPassword: State<TextFieldState> = _newPassword


    private val _newPasswordConfirm = mutableStateOf(
        TextFieldState(
            hint = application.getString(R.string.confirm_new_password),
            icon = Icons.Default.VpnKey
        )
    )
    val newPasswordConfirm: State<TextFieldState> = _newPasswordConfirm


    private val _newPasswordDone = mutableStateOf(
        SignSubmitState(text = application.getString(R.string.done))
    )
    val newPasswordDone : State<SignSubmitState> = _newPasswordDone


    fun onEvent(event: AuthEvent){
        when(event){
            is AuthEvent.EnteredPasswordSignUp -> {
                _newPassword.value = newPassword.value.copy(
                    text = event.value
                )
            }

            is AuthEvent.ChangeFocusPasswordSignUp -> {
                _newPassword.value = newPassword.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            newPassword.value.text.isBlank()
                )
            }

            is AuthEvent.EnteredPasswordConfirmSignUp -> {
                _newPasswordConfirm.value = newPasswordConfirm.value.copy(
                    text = event.value
                )
            }

            is AuthEvent.ChangeFocusPasswordSignUp -> {
                _newPasswordConfirm.value = newPasswordConfirm.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            newPasswordConfirm.value.text.isBlank()
                )
            }
            is AuthEvent.NewPasswordDone -> {

            }
            else -> {}
        }

    }

}
package com.example.bookandroid.authfeature.front.forgetpassword

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bookandroid.R
import com.example.bookandroid.authfeature.common.Constants
import com.example.bookandroid.authfeature.domain.usecase.AuthKtorUseCases
import com.example.bookandroid.authfeature.domain.usecase.AuthUseCases
import com.example.bookandroid.authfeature.front.signuporin.AuthEvent
import com.example.bookandroid.authfeature.front.signuporin.SignSubmitState
import com.example.bookandroid.authfeature.front.signuporin.SignViewModel
import com.example.bookandroid.authfeature.front.signuporin.TextFieldState
import com.example.bookandroid.authfeature.front.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@OptIn(ExperimentalFoundationApi::class)
@HiltViewModel
class ForgetPasswordViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val authKtorUseCases: AuthKtorUseCases,
    @SuppressLint("StaticFieldLeak") @ApplicationContext private val application: Context
): ViewModel() {
    private val _isKeyBoardOpen: State<Boolean> = mutableStateOf(
        value = false
    )

    var isKeyBoardOpen: State<Boolean> = _isKeyBoardOpen


    private val _forgetPassInfo = mutableStateOf(
        TextFieldState(
            hint = application.getString(R.string.sign_up_info_hint),
            icon = Icons.Default.Person
        )
    )
    val forgetPassInfo: State<TextFieldState> = _forgetPassInfo


    private val _forgetPassCode = mutableStateOf(
        TextFieldState(
            hint = application.getString(R.string.code),
            icon = Icons.Default.Code
        )
    )
    val forgetPassCode: State<TextFieldState> = _forgetPassCode

    private val _forgetDoneButton = mutableStateOf(
        SignSubmitState(text = application.getString(R.string.code))
    )
    val forgetDoneButton : State<SignSubmitState> = _forgetDoneButton


    fun onEvent(event: AuthEvent){

        when(event){
            is AuthEvent.SendCode -> {
                if (isEmail(_forgetPassInfo.value.text)){
//                    authKtorUseCases.otpEmail.invoke(_forgetPassInfo.value.text)
                }else if(isPhoneNumber(_forgetPassInfo.value.text)) {
                    authKtorUseCases.otpPhoneNumber.invoke(_forgetPassInfo.value.text)
                }
            }


            is AuthEvent.EnteredForgetPassValue -> {
                _forgetPassInfo.value = forgetPassInfo.value.copy(
                    text = event.value
                )
            }

            is AuthEvent.ChangeFocusForgetPassValue -> {
                _forgetPassInfo.value = forgetPassInfo.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            forgetPassInfo.value.text.isBlank()
                )
            }


            is AuthEvent.EnteredForgetPassCode -> {
                _forgetPassCode.value = forgetPassCode.value.copy(
                    text = event.value
                )
            }

            is AuthEvent.ChangeFocusForgetPassCode -> {
                _forgetPassCode.value = forgetPassCode.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            forgetPassCode.value.text.isBlank()
                )
            }
            is AuthEvent.ForgetDone -> {
                event.navController.navigate(Screen.NewPasswordScreen.route + "")
            }

        }
    }


    private fun isPhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.matches(
            Regex(
                application.getString(R.string.phone_number_regex)
            )
        ) && phoneNumber.length == Constants.PHONE_NUMBER_LENGTH

    }

    private fun isEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isUserName(userName: String): Boolean {
        return userName.matches(Regex(application.getString(R.string.username_regex))) && userName.length > 4
    }



}



package com.example.bookandroid.authfeature.front.signuporin

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.VpnKey
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookandroid.BookApp
import com.example.bookandroid.R
import com.example.bookandroid.authfeature.common.Constants
import com.example.bookandroid.authfeature.domain.model.InvalidUserException
import com.example.bookandroid.authfeature.domain.model.SignUser
import com.example.bookandroid.authfeature.domain.usecase.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    @SuppressLint("StaticFieldLeak") @ApplicationContext private val application : Context
) : ViewModel() {




    private val _isSignIn = mutableStateOf(
        SignModeButtonState(
            text = application.getString(R.string.signin),
            isSelected = true,
        )
    )
    val isSignIn : State<SignModeButtonState> = _isSignIn

    private val _isSignUp = mutableStateOf(
        SignModeButtonState(
            text = application.getString(R.string.signup),
            isSelected = false
        )
    )
    val isSignUp : State<SignModeButtonState> = _isSignUp



    private val _state = mutableStateOf(AuthState())
    val state: State<AuthState> = _state

    private val _signInInfo = mutableStateOf(
        TextFieldState(
            hint = application.getString(R.string.sign_in_info_hint),
            icon = Icons.Default.Person
        )
    )
    val signInInfo: State<TextFieldState> = _signInInfo

    private val _passwordSignIn = mutableStateOf(
        TextFieldState(
            hint = application.getString(R.string.password),
            icon = Icons.Default.VpnKey
        )
    )
    val passwordSignIn: State<TextFieldState> = _passwordSignIn


    private val _signUpInfo = mutableStateOf(
        TextFieldState(
            hint = application.getString(R.string.sign_up_info_hint),
            icon = Icons.Default.Person
        )
    )
    val signUpInfo: State<TextFieldState> = _signUpInfo


    private val _signUpUsername = mutableStateOf(
        TextFieldState(
            hint = application.getString(R.string.username),
            icon =Icons.Default.VerifiedUser
        )
    )
    val signUpUsername: State<TextFieldState> = _signUpUsername



    private val _passwordConfirm = mutableStateOf(
        TextFieldState(
            hint = application.getString(R.string.confirm_password),
            icon = Icons.Default.VpnKey
        )
    )
    val passwordConfirm: State<TextFieldState> = _passwordConfirm


    private val _passwordSignUp = mutableStateOf(
        TextFieldState(
            hint = application.getString(R.string.password),
            icon = Icons.Default.VpnKey
        )
    )
    val passwordSignUp: State<TextFieldState> = _passwordSignUp











    private val _eventFlow = MutableSharedFlow<AuthEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {

    }


    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.ForgetPassword -> {

            }

            is AuthEvent.IsSignIn ->{
                _isSignIn.value = isSignIn.value.copy(isSelected = true)
                _isSignUp.value = isSignUp.value.copy(isSelected = false)
            }


            is AuthEvent.IsSignUp ->{
                _isSignIn.value = isSignIn.value.copy(isSelected = false)
                _isSignUp.value = isSignUp.value.copy(isSelected = true)
            }


            is AuthEvent.EnteredValueSignIn -> {
                _signInInfo.value = signInInfo.value.copy(
                    text = event.value
                )
            }

            is AuthEvent.ChangeFocusValueSignIn -> {
                _signInInfo.value = signInInfo.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            signInInfo.value.text.isBlank()
                )
            }

            is AuthEvent.EnteredUsernameSignUp -> {
                _signUpUsername.value = signUpUsername.value.copy(
                    text = event.value
                )
            }

            is AuthEvent.ChangeFocusValueSignIn -> {
                _signUpUsername.value = signUpUsername.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            signUpUsername.value.text.isBlank()
                )
            }

            is AuthEvent.EnteredValueSignUp -> {
                _signUpInfo.value = signUpInfo.value.copy(
                    text = event.value
                )
            }

            is AuthEvent.ChangeFocusValueSignUp -> {
                _signUpInfo.value = signUpInfo.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            signUpInfo.value.text.isBlank()
                )
            }

            is AuthEvent.EnteredPasswordSignIn-> {
                _passwordSignIn.value = passwordSignIn.value.copy(
                    text = event.value
                )
            }

            is AuthEvent.ChangeFocusPasswordSignIn -> {
                _passwordSignIn.value = passwordSignIn.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            passwordSignIn.value.text.isBlank()
                )
            }

            is AuthEvent.EnteredPasswordSignUp-> {
                _passwordSignUp.value = passwordSignUp.value.copy(
                    text = event.value
                )
            }

            is AuthEvent.ChangeFocusPasswordSignUp -> {
                _passwordSignUp.value = passwordSignUp.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            passwordSignUp.value.text.isBlank()
                )
            }

            is AuthEvent.EnteredPasswordConfirmSignUp-> {
                _passwordConfirm.value = passwordConfirm.value.copy(
                    text = event.value
                )
            }

            is AuthEvent.ChangeFocusPasswordSignUp -> {
                _passwordConfirm.value = passwordConfirm.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            passwordConfirm.value.text.isBlank()
                )
            }


            is AuthEvent.SignIn -> {
                if (isEmail(email = signInInfo.value.text)) {
                    viewModelScope.launch {
                        try {
                            authUseCases.signInEmail(
                                user = SignUser(
                                    email = signInInfo.value.text,
                                    passwordAuthentication = passwordSignIn.value.text,
                                    phoneNumber = "",
                                    username = ""
                                )
                            )
                            _eventFlow.emit(
                                AuthEvent.SignIn
                            )
                        } catch (e: InvalidUserException) {
                            _eventFlow.emit(
                                AuthEvent.ShowSnackBar(
                                    message = e.message ?: "Sign in un successful"
                                )
                            )
                        }
                    }
                } else if (isPhoneNumber(phoneNumber = signInInfo.value.text) && passwordSignIn.value.text != null) {
                    viewModelScope.launch {
                        try {
                            authUseCases.signInPhoneNumber(
                                user = SignUser(
                                    email = "",
                                    passwordAuthentication = "",
                                    phoneNumber = signInInfo.value.text,
                                    username = ""
                                )
                            )
                            _eventFlow.emit(
                                AuthEvent.SignIn
                            )
                        } catch (e: InvalidUserException) {
                            _eventFlow.emit(
                                AuthEvent.ShowSnackBar(
                                    message = e.message ?: "Sign in un successful"
                                )
                            )
                        }
                    }
                } else if (isPhoneNumber(phoneNumber = signInInfo.value.text) && passwordSignIn.value.text != null) {
                    viewModelScope.launch {
                        try {
                            authUseCases.signInPhoneNumber(
                                user = SignUser(
                                    email = "",
                                    passwordAuthentication = "",
                                    phoneNumber = signInInfo.value.text,
                                    username = ""
                                )
                            )
                            _eventFlow.emit(
                                AuthEvent.SignIn
                            )
                        } catch (e: InvalidUserException) {
                            _eventFlow.emit(
                                AuthEvent.ShowSnackBar(
                                    message = e.message ?: "Sign in un successful"
                                )
                            )
                        }
                    }
                }
            }


            is AuthEvent.SignUp -> {
                if (isEmail(email = signInInfo.value.text) && passwordSignUp.value.text != null && (passwordSignUp.value.text == passwordConfirm.value.text)) {
                    viewModelScope.launch {
                        try {
                            authUseCases.signUpEmail(
                                user = SignUser(
                                    email = signInInfo.value.text,
                                    passwordAuthentication = passwordSignUp.value.text,
                                    phoneNumber = "",
                                    username = ""
                                )
                            )
                            _eventFlow.emit(
                                AuthEvent.SignUp
                            )
                        } catch (e: InvalidUserException) {
                            _eventFlow.emit(
                                AuthEvent.ShowSnackBar(
                                    message = e.message ?: "Sign up un successful"
                                )
                            )
                        }
                    }
                } else if (isPhoneNumber(phoneNumber = signInInfo.value.text) && passwordSignUp.value.text != null && (passwordSignUp.value.text == passwordConfirm.value.text)) {
                    viewModelScope.launch {
                        try {
                            authUseCases.signUpPhoneNumber(
                                user = SignUser(
                                    email = "",
                                    passwordAuthentication = "",
                                    phoneNumber = signUpInfo.value.text,
                                    username = ""
                                )
                            )
                            _eventFlow.emit(
                                AuthEvent.SignUp
                            )
                        } catch (e: InvalidUserException) {
                            _eventFlow.emit(
                                AuthEvent.ShowSnackBar(
                                    message = e.message ?: "Sign up un successful"
                                )
                            )
                        }
                    }
                }
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
        return userName.matches(Regex(application.getString(R.string.username_regex)))
    }


}
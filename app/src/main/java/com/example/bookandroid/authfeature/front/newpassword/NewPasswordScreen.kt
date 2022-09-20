package com.example.bookandroid.authfeature.front.forgetpassword

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookandroid.R
import com.example.bookandroid.authfeature.front.forgetpassword.components.Timer
import com.example.bookandroid.authfeature.front.newpassword.NewPasswordViewModel
import com.example.bookandroid.authfeature.front.signuporin.AuthEvent
import com.example.bookandroid.authfeature.front.signuporin.SignViewModel
import com.example.bookandroid.authfeature.front.signuporin.components.SignSubmitButton
import com.example.bookandroid.authfeature.front.signuporin.components.TransparentHintTextField
import com.example.bookandroid.authfeature.front.signuporin.components.keyboardState
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewPasswordScreen(navController: NavController , viewModel: NewPasswordViewModel = hiltViewModel()) {
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = BringIntoViewRequester()

    val isKeyboardOpen by keyboardState()

    if (isKeyboardOpen.equals(com.example.bookandroid.authfeature.front.signuporin.components.Keyboard.Closed)) {
        viewModel.isKeyBoardOpen = remember { mutableStateOf(false) }
    } else {
        viewModel.isKeyBoardOpen = remember { mutableStateOf(true) }
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = if (isSystemInDarkTheme()) painterResource(R.drawable.book_background_dark) else
                painterResource(R.drawable.book_light_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(fraction = 50f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            viewModel.newPassword.value.apply {
                TransparentHintTextField(
                    text = text,
                    hint = hint,
                    onFocusChange = {
                        if (it.isFocused) {
                            coroutineScope.launch {
                                bringIntoViewRequester.bringIntoView()
                                viewModel.isKeyBoardOpen = mutableStateOf(value = true)
                            }

                        } else {
                            viewModel.isKeyBoardOpen = mutableStateOf(value = false)
                        }
                        viewModel.onEvent(AuthEvent.ChangeFocusNewPassword(it))
                    },
                    onValueChange = {
                        viewModel.onEvent(AuthEvent.EnteredNewPassword(it))
                    },
                    icon = icon,
                    keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))


            Box(modifier = Modifier) {
                viewModel.newPasswordConfirm.value.apply {
                    TransparentHintTextField(
                        text = text,
                        hint = hint,
                        onFocusChange = {
                            if (it.isFocused) {
                                coroutineScope.launch {
                                    bringIntoViewRequester.bringIntoView()
                                    viewModel.isKeyBoardOpen = mutableStateOf(value = true)
                                }

                            } else {
                                viewModel.isKeyBoardOpen = mutableStateOf(value = false)
                            }
                            viewModel.onEvent(AuthEvent.ChangeFocusNewPasswordConfirm(it))
                        },
                        onValueChange = {
                            viewModel.onEvent(AuthEvent.EnteredNewPasswordConfirm(it))
                        },
                        icon = icon,
                        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                        padding = PaddingValues(start = 30.dp, end = 5.dp)
                    )
                }

            }
        }
        Spacer(modifier = Modifier.height(35.dp))


        SignSubmitButton(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
            text =viewModel.newPasswordDone.value.text,
            onClick = { viewModel.onEvent(AuthEvent.NewPasswordDone) },
            shape = RoundedCornerShape(5.dp)
        )

    }


}

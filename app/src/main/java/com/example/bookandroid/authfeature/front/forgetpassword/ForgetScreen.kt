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
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.bookandroid.R
import com.example.bookandroid.authfeature.front.forgetpassword.components.SendCodeButton
import com.example.bookandroid.authfeature.front.forgetpassword.components.Timer
import com.example.bookandroid.authfeature.front.signuporin.AuthEvent
import com.example.bookandroid.authfeature.front.signuporin.SignViewModel
import com.example.bookandroid.authfeature.front.signuporin.components.SignSubmitButton
import com.example.bookandroid.authfeature.front.signuporin.components.TransparentHintTextField
import com.example.bookandroid.authfeature.front.signuporin.components.keyboardState
import com.example.bookandroid.authfeature.front.theme.BookAndroidTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ForgetScreen(
    viewModel: SignViewModel = hiltViewModel()
) {


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

            viewModel.forgetPassInfo.value.apply {
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
                        viewModel.onEvent(AuthEvent.ChangeFocusForgetPassValue(it))
                    },
                    onValueChange = {
                        viewModel.onEvent(AuthEvent.EnteredForgetPassValue(it))
                    },
                    icon = icon,
                    keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(verticalAlignment = Alignment.Bottom) {
                Box(modifier = Modifier.weight(0.8f)) {
                    viewModel.forgetPassCode.value.apply{
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
                                viewModel.onEvent(AuthEvent.ChangeFocusForgetPassCode(it))
                            },
                            onValueChange = {
                                viewModel.onEvent(AuthEvent.EnteredForgetPassCode(it))
                            },
                            icon = Icons.Default.Code,
                            keyboardActions = KeyboardActions(onDone = {focusManager.clearFocus()}),
                            padding = PaddingValues(start = 30.dp, end = 5.dp)
                        )
                    }
                }

                Column(modifier = Modifier.weight(0.2f), verticalArrangement = Arrangement.Bottom) {

                    Timer(
                        viewModel = viewModel,
                        totalTime = 100L * 1000L,
                        handleColor = MaterialTheme.colors.primary,
                        inactiveBarColor = MaterialTheme.colors.primary,
                        activeBarColor = MaterialTheme.colors.secondary,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
            Spacer(Modifier.height(35.dp))

            SignSubmitButton(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                text = stringResource(R.string.done),
                onClick = {viewModel.onEvent(AuthEvent.ForgetDone)},
                shape = RoundedCornerShape(5.dp)
            )

        }


    }


}

//@Preview
//@Composable
//fun ForgetScreenPriview() {
//    BookAndroidTheme {
//        ForgetScreen()
//    }
//}
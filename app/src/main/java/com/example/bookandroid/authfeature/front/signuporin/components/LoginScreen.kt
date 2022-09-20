package com.example.bookandroid.authfeature.front.signuporin


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookandroid.authfeature.front.signuporin.components.LoginItemShape
import com.example.bookandroid.authfeature.front.signuporin.components.SignButton
import com.example.bookandroid.authfeature.front.signuporin.components.SignSubmitButton
import com.example.bookandroid.authfeature.front.theme.BookAndroidTheme
import com.example.bookandroid.R


@ExperimentalAnimationApi
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: SignViewModel = hiltViewModel()
) {






    ConstraintLayout(modifier = Modifier.background(color = Color.White)) {

        Image(modifier = Modifier.fillMaxSize(),
            painter = if (isSystemInDarkTheme()) painterResource(R.drawable.book_background_dark) else
                painterResource(R.drawable.book_light_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        val (shape, buttons, submit) = createRefs()

        Box(modifier = Modifier.constrainAs(shape) {
            end.linkTo(parent.end, margin = 0.dp)
            top.linkTo(parent.top, margin = 25.dp)
            bottom.linkTo(parent.bottom)


        }) {


                LoginItemShape(
                    navController = navController,
                    modifier = Modifier,
                    colors = listOf(
                        MaterialTheme.colors.primaryVariant,
                        MaterialTheme.colors.secondaryVariant
                    ),
                    signUp = viewModel.isSignUp.value.isSelected,
                    viewModel = viewModel
                )


        }

        Column(modifier = Modifier.constrainAs(buttons) {
            end.linkTo(shape.start, margin = -80.dp)
            bottom.linkTo(shape.bottom)
            top.linkTo(shape.top)
        }) {
            SignButton(modifier = Modifier, text = viewModel.isSignIn.value.text,
                onClick = {
                    viewModel.onEvent(AuthEvent.IsSignIn)
                }, isSelected = viewModel.isSignIn.value.isSelected
            )

            Spacer(modifier = Modifier.height(10.dp))

            SignButton(modifier = Modifier, text = viewModel.isSignUp.value.text,
                onClick = {
                    viewModel.onEvent(AuthEvent.IsSignUp)
                }, isSelected = viewModel.isSignUp.value.isSelected
            )

        }


    }
}


//@OptIn(ExperimentalAnimationApi::class)
//@Preview
//@Composable
//fun LoginScreenShape() {
//
//    BookAndroidTheme(darkTheme = true) {
//        LoginScreen()
//
//    }
//}
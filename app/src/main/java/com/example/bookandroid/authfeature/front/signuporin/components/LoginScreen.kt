package com.example.bookandroid.authfeature.front.signuporin


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookandroid.authfeature.front.signuporin.components.SignButton
import com.example.bookandroid.authfeature.front.theme.BookAndroidTheme
import java.lang.Math.PI
import java.lang.Math.sqrt
import kotlin.math.pow
import kotlin.math.sqrt


@ExperimentalAnimationApi
@Composable
fun LoginScreen(

//    viewModel: SignViewModel = hiltViewModel()
) {


    ConstraintLayout(modifier = Modifier.background(color = Color.White)) {


        val (shape, buttons) = createRefs()

        Box(modifier = Modifier.constrainAs(shape) {
            end.linkTo(parent.end, margin = 0.dp)
            top.linkTo(parent.top, margin = 50.dp)
            bottom.linkTo(parent.bottom)


        }) {

            LoginItemShape(
                modifier = Modifier,
                colors = listOf(MaterialTheme.colors.primaryVariant, MaterialTheme.colors.secondaryVariant),
                signUp = false
            )

        }

        Column(modifier = Modifier.constrainAs(buttons){
            end.linkTo(shape.start , margin = -80.dp)
            bottom.linkTo(shape.bottom)
            top.linkTo(shape.top)
        }) {
            SignButton(modifier = Modifier , text = "Sign In" ,
                onClick ={
                  //  viewModel.onEvent(AuthEvent.IsSignIn)
                         } , isSelected = true)

            Spacer(modifier = Modifier.height(10.dp))

            SignButton(modifier = Modifier , text = "Sign Up" ,
                onClick ={
                  //  viewModel.onEvent(AuthEvent.IsSignUp)
                         } , isSelected = false)

        }


    }
}


@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun LoginScreenShape() {

    BookAndroidTheme(darkTheme = true) {
        LoginScreen()

    }
}
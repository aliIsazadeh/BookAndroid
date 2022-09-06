package com.example.bookandroid.authfeature.front.signuporin.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.bookandroid.R
import com.example.bookandroid.authfeature.front.signuporin.AuthEvent
import com.example.bookandroid.authfeature.front.signuporin.SignViewModel
import com.example.bookandroid.authfeature.front.theme.BookAndroidTheme


@Composable
fun LoginItemShape(modifier: Modifier = Modifier, signUp: Boolean = true, colors: List<Color> , viewModel : SignViewModel) {




    Box(
        modifier = modifier
            .size(height = 530.dp, width = 1000.dp)
    ) {

        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.End) {

            Canvas(modifier = Modifier.fillMaxHeight().fillMaxWidth(fraction = 0.85f)) {

                val canvasSize: Size = size
                CornerRadius(x = 80f, y = 80f)


                val selectSize: Float = if (signUp) {
                    size.height / 1.85f
                } else {
                    size.height / 2.15f
                }


                val roundThreePath = Path().apply {
//                lineTo(0f, size.height)
//                lineTo(size.width, size.height /2f)
                    moveTo(size.width, 0f)
                    lineTo(size.width / 10f, selectSize)
                    lineTo(size.width, size.height)
                    moveTo(size.width, size.height)
                    lineTo(size.width / 10f, selectSize)


                    close()
                }

                val threePath = Path().apply {
//                lineTo(0f, size.height)
//                lineTo(size.width, size.height /2f)
                    moveTo(size.width - 25f, 0f)
                    lineTo(size.width / 9f, selectSize)
                    lineTo(size.width - 25f, size.height)
                    moveTo(size.width - 25f, size.height)
                    lineTo(size.width / 9f, selectSize)


                    close()
                }

//            drawOutline()

                drawIntoCanvas { canvas ->


                    canvas.drawOutline(
                        outline = Outline.Generic(path = roundThreePath),
                        paint = Paint().apply {
                            color = colors[1]
                            pathEffect = PathEffect.cornerPathEffect(30f)

                        },

                        )

                    drawOutline(
                        outline = Outline.Generic(path = threePath),
                        brush = Brush.linearGradient
                            (
                            colors = colors,
                            start = Offset(x = size.width - size.width / 18f, size.height / 9f),
                            end = Offset(x = size.width / 11f, size.height / 4f)
                        ),

                        )
                }

            }

        }

        Row(modifier = modifier.fillMaxSize(), horizontalArrangement = Arrangement.End) {


            ConstraintLayout() {

                val (canvas, column, title , submit) = createRefs()


                Canvas(
                    modifier = Modifier.fillMaxHeight().fillMaxWidth(fraction = 0.67f)
                        .constrainAs(canvas) {
                            end.linkTo(parent.end)
                        }) {

                    val canvasSize = size
                    val canvasWidth = size.width
                    val canvasHeight = size.height
                    val cornerRadiusRect = CornerRadius(x = 80f, y = 80f)


                    val rectPath = Path().apply {


                        addRoundRect(
                            RoundRect(
                                rect = Rect(
                                    offset = Offset(
                                        x = canvasWidth / 300F,
                                        y = canvasHeight / 300F
                                    ),
                                    size = canvasSize / 1F,
                                ),
                                bottomLeft = cornerRadiusRect,
                                topLeft = cornerRadiusRect
                            )
                        )
                    }


                    drawPath(
                        rectPath,
                        brush = Brush.linearGradient
                            (
                            colors = colors,
                            start = Offset(x = size.width - size.width / 18f, size.height / 9f),
                            end = Offset(x = size.width / 11f, size.height / 4f)
                        ),
                    )

                }

                Text(
                    modifier = Modifier.constrainAs(title) {
                        start.linkTo(canvas.start, margin = 20.dp)
                        top.linkTo(canvas.top, margin = 40.dp)
                    },
                    text = if (signUp) stringResource(R.string.signup)
                    else stringResource(R.string.signin), style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onSecondary
                )


                if (signUp) {
                    Column(
                        modifier = Modifier.fillMaxHeight().fillMaxWidth(fraction = 0.71f)
                            .constrainAs(column) {
                                start.linkTo(canvas.start)
                                end.linkTo(canvas.end)
                                top.linkTo(canvas.top, margin = 150.dp)
                            }) {
                        viewModel.signUpUsername.value.apply{
                            TransparentHintTextField(
                                text = text,
                                hint = hint + "*",
                                isHintVisible = true,
                                textStyle = TextStyle(color = MaterialTheme.colors.onPrimary),
                                onValueChange = {viewModel.onEvent(AuthEvent.EnteredUsernameSignUp(it))},
                                singleLine = true,
                                onFocusChange = {viewModel.onEvent(AuthEvent.ChangeFocusUsernameSignUp(it))},
                                icon = icon
                            )
                        }

                        Spacer(modifier = Modifier.height(15.dp))


                        viewModel.signUpInfo.value.apply{
                            TransparentHintTextField(
                                text = text,
                                hint = hint + "*",
                                isHintVisible = true,
                                textStyle = TextStyle(color = MaterialTheme.colors.onPrimary),
                                onValueChange = {viewModel.onEvent(AuthEvent.EnteredValueSignUp(it))},
                                singleLine = true,
                                onFocusChange = {viewModel.onEvent(AuthEvent.ChangeFocusValueSignUp(it))},
                                icon = icon
                            )
                        }


                        Spacer(modifier = Modifier.height(15.dp))


                        viewModel.passwordSignUp.value.apply{
                            TransparentHintTextField(
                                text = text,
                                hint = hint + "*",
                                isHintVisible = true,
                                textStyle = TextStyle(color = MaterialTheme.colors.onPrimary),
                                onValueChange = {viewModel.onEvent(AuthEvent.EnteredPasswordSignUp(it))},
                                singleLine = true,
                                onFocusChange = {viewModel.onEvent(AuthEvent.ChangeFocusPasswordSignUp(it))},
                                icon = icon
                            )
                        }


                        Spacer(modifier = Modifier.height(15.dp))


                        viewModel.passwordConfirm.value.apply{
                            TransparentHintTextField(
                                text = text,
                                hint = hint + "*",
                                isHintVisible = true,
                                textStyle = TextStyle(color = MaterialTheme.colors.onPrimary),
                                onValueChange = {viewModel.onEvent(AuthEvent.EnteredPasswordConfirmSignUp(it))},
                                singleLine = true,
                                onFocusChange = {viewModel.onEvent(AuthEvent.ChangeFocusPasswordConfirmSignUp(it))},
                                icon = icon
                            )
                        }

                    }
                } else {
                    Column(
                        modifier = Modifier.fillMaxHeight().fillMaxWidth(fraction = 0.71f)
                            .constrainAs(column) {
                                start.linkTo(canvas.start)
                                end.linkTo(canvas.end)
                                top.linkTo(canvas.top, margin = 170.dp)
                            }) {

                        viewModel.signInInfo.value.apply{
                            TransparentHintTextField(
                                text = text,
                                hint = hint + "*",
                                isHintVisible = true,
                                textStyle = TextStyle(color = MaterialTheme.colors.onPrimary),
                                onValueChange = {viewModel.onEvent(AuthEvent.EnteredValueSignIn(it))},
                                singleLine = true,
                                onFocusChange = {viewModel.onEvent(AuthEvent.ChangeFocusValueSignIn(it))},
                                icon = icon
                            )
                        }

                        Spacer(modifier = Modifier.height(35.dp))


                        viewModel.passwordSignIn.value.apply{
                            TransparentHintTextField(
                                text = text,
                                hint = hint + "*",
                                isHintVisible = true,
                                textStyle = TextStyle(color = MaterialTheme.colors.onPrimary),
                                onValueChange = {viewModel.onEvent(AuthEvent.EnteredPasswordSignIn(it))},
                                singleLine = true,
                                onFocusChange = {viewModel.onEvent(AuthEvent.ChangeFocusPasswordSignIn(it))},
                                icon = icon
                            )
                        }

                        Spacer(modifier = Modifier.height(25.dp))

                        TextButton(onClick = {viewModel.onEvent(AuthEvent.ForgetPassword)} , modifier = Modifier.padding(horizontal = 30.dp)) {
                            Text(
                                stringResource(R.string.forget_password),
                                style = TextStyle(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colors.onSecondary
                            )
                        }


                    }
                }
                SignSubmitButton(modifier = Modifier.width(width =180.dp).constrainAs(submit){
                    top.linkTo(canvas.bottom , margin = -10.dp)
                    start.linkTo(column.start , margin = 0.dp)
                    end.linkTo(column.end , margin = 0.dp)
                },onClick = {
                    if (viewModel.isSignIn.value.isSelected) {
                        viewModel.onEvent(AuthEvent.SignIn)
                    } else viewModel.onEvent(AuthEvent.SignUp)
                },
                    text = if(viewModel.isSignUp.value.isSelected) stringResource(R.string.signup)
                    else stringResource(R.string.signin))
            }


        }
    }
}


@Preview
@Composable
fun LoginItemShapePreview() {

    BookAndroidTheme {
//        LoginItemShape(
//            colors = listOf(
//                MaterialTheme.colors.primaryVariant,
//                MaterialTheme.colors.secondaryVariant
//            ), signUp = false
//        )
    }
}
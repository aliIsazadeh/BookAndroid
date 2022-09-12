package com.example.bookandroid.authfeature.front.forgetpassword.components
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.sp
import com.example.bookandroid.R
import com.example.bookandroid.authfeature.front.signuporin.AuthEvent
import com.example.bookandroid.authfeature.front.signuporin.SignViewModel
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
// create a composable to
// Draw arc and handle
@Composable
fun Timer(

    viewModel: SignViewModel,

    // total time of the timer
    totalTime: Long,

    // circular handle color
    handleColor: Color,

    // color of inactive bar / progress bar
    inactiveBarColor: Color,

    // color of active bar
    activeBarColor: Color,
    modifier: Modifier = Modifier,

    // set initial value to 1
    initialValue: Float = 1f,
    strokeWidth: Dp = 2.dp
) {
    // create variable for
    // size of the composable
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    // create variable for value
    var value by remember {
        mutableStateOf(initialValue)
    }
    // create variable for current time
    var currentTime by remember {
        mutableStateOf(0L)
    }
    // create variable for isTimerRunning
    var isTimerRunning by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if(currentTime > 0 && isTimerRunning) {
            delay(100L)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .onSizeChanged {
                size = it
            }
    ) {
        if (currentTime>0L) {
            // draw the timer
            Canvas(modifier = modifier.align(Alignment.Center),) {
                // draw the inactive arc with following parameters
                drawArc(
                    color = inactiveBarColor, // assign the color
                    startAngle = -215f, // assign the start angle
                    sweepAngle = 250f, // arc angles
                    useCenter = false, // prevents our arc to connect at te ends
                    size = Size(size.width.toFloat(), size.height.toFloat()),

                    // to make ends of arc round
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
                // draw the active arc with following parameters
                drawArc(
                    color = activeBarColor, // assign the color
                    startAngle = -215f,  // assign the start angle
                    sweepAngle = 250f * value, // reduce the sweep angle
                    // with the current value
                    useCenter = false, // prevents our arc to connect at te ends
                    size = Size(size.width.toFloat(), size.height.toFloat()),

                    // to make ends of arc round
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
                // calculate the value from arc pointer position
                val center = Offset(size.width / 2f, size.height / 2f)
                val beta = (250f * value + 145f) * (PI / 180f).toFloat()
                val r = size.width / 2f
                val a = cos(beta) * r
                val b = sin(beta) * r
                // draw the circular pointer/ cap
                drawPoints(
                    listOf(Offset(center.x + a, center.y + b)),
                    pointMode = PointMode.Points,
                    color = handleColor,
                    strokeWidth = (strokeWidth * 1f).toPx(),
                    cap = StrokeCap.Round  // make the pointer round
                )
            }
            // add value of the timer
            Text(
                text = (currentTime / 1000L).toString(),
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }else
            TextButton(
                onClick = {
                        currentTime = totalTime
                        isTimerRunning = true
                    viewModel.onEvent(AuthEvent.SendCode)
                },
                modifier = Modifier.align(Alignment.BottomCenter),

            ) {
                Text(
                    // change the text of button based on values
                    text = stringResource(R.string.send_code ) ,
                    color = MaterialTheme.colors.onSecondary,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
    }
}

@Preview
@Composable
fun TimerPriview(){
    Box(
        contentAlignment = Alignment.Center,

    ) {
        // call the function Timer
        // and pass the values
        // it is defined below.
//        Timer(
//            totalTime = 100L * 1000L,
//            handleColor = Color.Green,
//            inactiveBarColor = Color.DarkGray,
//            activeBarColor = Color(0xFF37B900),
//            modifier = Modifier.size(50.dp)
//        )
    }
}
package com.example.bookandroid.authfeature.front.signuporin.components

import android.graphics.BlurMaskFilter
import android.graphics.Color
import android.os.Build
import android.text.BoringLayout
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.font.FontWeight.Companion.Black
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.blue
import com.example.bookandroid.authfeature.domain.usecase.AuthUseCases
import com.example.bookandroid.authfeature.front.signuporin.AuthEvent
import com.example.bookandroid.authfeature.front.signuporin.SignViewModel

@Composable
fun SignButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    isSelected: Boolean
) {

    if (isSelected) {
        Button(
            onClick = onClick, colors = ButtonDefaults.buttonColors(
                backgroundColor =
                MaterialTheme.colors.primary
            ),
            shape = RoundedCornerShape(40.dp),
            modifier = Modifier
                .coloredShadow(
                    color = Color.BLACK, offsetX = 0.dp, offsetY = 15.dp,
                    blurRadius = 15.dp, spread = 1f, borderRadius = 30.dp
                )
                .border(
                    width = 0.dp,
                    shape = RectangleShape,
                    color = androidx.compose.ui.graphics.Color.Transparent
                )
        ) {
            Text(text =  text )

        }
    } else {
        TextButton(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Transparent,
            ),
            shape = RoundedCornerShape(40.dp),
        ) {
            Text(text = text)
        }
    }


}

@Preview
@Composable
fun SignInButtonPreview() {

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        SignButton(text = "login", onClick = { /*TODO*/ }, isSelected = false)
    }

}

@Preview
@Composable
fun SignUpButtonPreview() {

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        SignButton(text = "Sign Up", onClick = { /*TODO*/ }, isSelected =true)
    }
}


fun Modifier.coloredShadow(
    color: Int = Color.BLACK,
    borderRadius: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    spread: Float = 0f,
    modifier: Modifier = Modifier,
) = this.then(
    modifier.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            val spreadPixel = spread.dp.toPx()
            val leftPixel = (0f - spreadPixel + 5f) + offsetX.toPx()
            val topPixel = (0f + 5f) + offsetY.toPx()
            val rightPixel = (this.size.width + spreadPixel - 5f)
//            val leftPixel = 0f
//            val topPixel = 0f
//            val rightPixel = 0f
            val bottomPixel = (this.size.height + spreadPixel)

            if (blurRadius != 0.dp) {
                /*
                    The feature maskFilter used below to apply the blur effect only works
                    with hardware acceleration disabled.
                 */
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }

            frameworkPaint.color = Color.BLACK
            it.drawRoundRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                radiusX = borderRadius.toPx(),
                radiusY = borderRadius.toPx(),
                paint
            )
        }
    }
)
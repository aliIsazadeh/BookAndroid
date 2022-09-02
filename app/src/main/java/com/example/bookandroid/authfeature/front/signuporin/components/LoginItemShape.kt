package com.example.bookandroid.authfeature.front.signuporin

import android.widget.EditText
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.example.bookandroid.authfeature.front.theme.BookAndroidTheme

@Composable
fun LoginItemShape(modifier: Modifier = Modifier, signUp: Boolean = true , colors : List<Color>) {
    val cornerRadius: Dp = 10.dp
    val cutCornerSize: Dp = 30.dp

    Box(
        modifier = modifier
            .size(height = 600.dp, width = 1000.dp)
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {

            val canvasSize = size
            val canvasWidth = size.width
            val canvasHeight = size.height
            val cornerRadiusRect = CornerRadius(x = 80f, y = 80f)
            val cornerRadiusSqu = CornerRadius(x = 20f, y = 20f)


            val rectPath = Path().apply {


                addRoundRect(
                    RoundRect(
                        rect = Rect(
                            offset = Offset(x = canvasWidth / 3F, y = canvasHeight / 300F),
                            size = canvasSize / 1F,
                        ),
                        bottomLeft = cornerRadiusRect,
                        topLeft = cornerRadiusRect
                    )
                )
            }
            var selectSize : Float

            if (signUp){
                selectSize = size.height/2.15f
            }else{
                selectSize = size.height/1.85f
            }


            val roundThreePath = Path().apply {
//                lineTo(0f, size.height)
//                lineTo(size.width, size.height /2f)
                moveTo(size.width, 0f)
                lineTo(size.width / 4f, selectSize)
                lineTo(size.width, size.height)
                moveTo(size.width, size.height)
                lineTo(size.width / 4f, selectSize)


                close()
            }

            val threePath = Path().apply {
//                lineTo(0f, size.height)
//                lineTo(size.width, size.height /2f)
                moveTo(size.width -50f, 0f)
                lineTo(size.width / 3.8f, selectSize)
                lineTo(size.width, size.height)
                moveTo(size.width -50f, size.height)
                lineTo(size.width / 3.5f, selectSize)


                close()
            }

//            drawOutline()

            drawIntoCanvas { canvas ->


                canvas.drawOutline(
                    outline = Outline.Generic(path = roundThreePath),
                    paint = Paint().apply {
                        color = colors.get(1)
                        pathEffect = PathEffect.cornerPathEffect(30f)

                    },

                    )

                drawOutline(
                    outline = Outline.Generic(path = threePath),
                    brush = Brush.linearGradient
                        (
                        colors = colors,
                        start = Offset(x=size.width - size.width/9f,size.height/9f),
                        end = Offset(x=size.width/5f,size.height/3f)
                    ),

                )
            }

            drawPath(
                rectPath,
                brush = Brush.linearGradient
                    (
                    colors = colors,
                    start = Offset(x=size.width - size.width/9f,size.height/9f),
                    end = Offset(x=size.width/5f,size.height/3f)
                ),
            )

        }


        Column(modifier = Modifier) {

//            OutlinedTextField(value = , onValueChange = )

        }


    }

}



@Preview
@Composable
fun LoginItemShapePreview() {
    val size: Size = Size(width = 1000f, height = 1000f)

    BookAndroidTheme(){
        LoginItemShape(
            colors = listOf(
                MaterialTheme.colors.primaryVariant,
                MaterialTheme.colors.secondaryVariant
            )
        )
    }
}
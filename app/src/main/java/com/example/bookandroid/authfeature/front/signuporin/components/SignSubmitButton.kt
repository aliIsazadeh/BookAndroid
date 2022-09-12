package com.example.bookandroid.authfeature.front.signuporin.components

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.bookandroid.authfeature.front.theme.BookAndroidTheme

@Composable
fun SignSubmitButton(modifier: Modifier,text : String , onClick : () -> Unit , shape: Shape = RoundedCornerShape(150.dp)) {

    Column(modifier = modifier){
        Button(
            onClick = onClick, shape = shape, modifier = modifier,
            colors = ButtonDefaults.buttonColors(backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.body2 , fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
        }
    }

}
@Preview
@Composable
fun SignSubmitButtonPriveiw(){
    BookAndroidTheme(darkTheme = false) {
        Box(modifier = Modifier.background(Color.Gray).size(200.dp)){ SignSubmitButton(Modifier,"Sign In", onClick = {}) }
    }
}
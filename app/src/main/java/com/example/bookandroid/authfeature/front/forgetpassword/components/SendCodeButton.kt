package com.example.bookandroid.authfeature.front.forgetpassword.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun SendCodeButton(modifier: Modifier , onClick : () -> Unit , text : String , enable : Boolean){

    Box(modifier = modifier){
        TextButton(onClick = onClick  , enabled = enable){
            Text(text , color = MaterialTheme.colors.onSecondary , style = TextStyle(fontWeight = FontWeight.Bold))
        }
    }


}
package com.example.bookandroid.authfeature.front.signuporin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookandroid.authfeature.front.theme.BookAndroidTheme


@Composable
fun TransparentHintTextField(
    text: String,
    hint: String,
    isHintVisible: Boolean = true,
    textStyle: TextStyle = TextStyle(),
    onValueChange: (String) -> Unit,
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit,
    icon: ImageVector,
    keyboardActions: KeyboardActions? = null,
    padding : PaddingValues = PaddingValues(horizontal = 30.dp)
) {
    Column(
        modifier = Modifier.padding(padding)
    ) {


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = hint, style = TextStyle(
                    fontWeight = FontWeight.W500,
                    color = MaterialTheme.colors.onSurface
                )
            )

            Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colors.onSurface , modifier = Modifier.size(15.dp))
        }

        Spacer(Modifier.height(2.dp))

        Column(modifier = Modifier.height(40.dp).background(
            color = MaterialTheme.colors.onBackground,
            shape = RoundedCornerShape(corner = CornerSize(5.dp) ,)
        ) , verticalArrangement = Arrangement.Center){
            BasicTextField(
                value = text,
                enabled = true,
                onValueChange = onValueChange,
                singleLine = singleLine,
                textStyle = MaterialTheme.typography.body1.copy
                    (textAlign = TextAlign.Center, textDecoration = TextDecoration.None),
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        onFocusChange(it)
                    },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
//                keyboardActions = keyboardActions!!
            )
        }


    }
}


//@Preview
//@Composable
//fun TextFildPreview() {
//
//    BookAndroidTheme {
//
//            TransparentHintTextField(
//                text = "",
//                hint = "Phone Number",
//                isHintVisible = true,
//                textStyle = MaterialTheme.typography.body2,
//                onValueChange = {},
//                singleLine = true,
//                onFocusChange = {},
//                icon = Icons.Default.Person
//            )
//
//    }
//}
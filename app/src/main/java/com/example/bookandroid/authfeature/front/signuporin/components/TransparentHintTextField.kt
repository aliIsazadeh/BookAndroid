@file:OptIn(ExperimentalMaterialApi::class)

package com.example.bookandroid.authfeature.front.signuporin.components

import android.graphics.drawable.Icon
import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Login
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookandroid.authfeature.front.theme.BookAndroidTheme
import com.example.bookandroid.authfeature.front.theme.TransparentWhite300
import com.example.bookandroid.authfeature.front.theme.TransparentWhite500


@Composable
fun TransparentHintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit,
    icon: ImageVector
) {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp)
    ) {


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = hint, style = TextStyle(
                    fontWeight = FontWeight.W500,
                    color = MaterialTheme.colors.onSurface
                )
            )

            Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colors.onSurface)
        }

        Spacer(Modifier.height(2.dp))

        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colors.onBackground,
                    shape = RoundedCornerShape(corner = CornerSize(5.dp))
                )
                .height(40.dp)
                .onFocusChanged {
                    onFocusChange(it)
                }
        )
        {
            Text(text = "", style = textStyle, color = MaterialTheme.colors.onPrimary)
        }

    }
}


@Preview
@Composable
fun TextFildPreview() {

    BookAndroidTheme {
        Box(
            modifier = Modifier.size(600.dp).background(color = MaterialTheme.colors.primary),
            contentAlignment = Alignment.Center
        ) {
            TransparentHintTextField(
                text = "",
                textStyle = MaterialTheme.typography.body2,
                hint = "Phone Number",
                modifier = Modifier.padding(horizontal = 30.dp),
                singleLine = true,
                isHintVisible = true,
                onFocusChange = {},
                onValueChange = {},
                icon = Icons.Default.Login
            )
        }
    }
}
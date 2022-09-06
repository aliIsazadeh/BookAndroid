package com.example.bookandroid.authfeature.front.signuporin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DisabledByDefault
import androidx.compose.ui.graphics.vector.ImageVector

data class TextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true,
    val icon : ImageVector = Icons.Default.DisabledByDefault
)

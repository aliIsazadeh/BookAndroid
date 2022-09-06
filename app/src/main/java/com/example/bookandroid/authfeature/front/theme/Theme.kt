package com.example.bookandroid.authfeature.front.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = HippieBlue,
    primaryVariant = BilzzardBlue,
    secondary = Carnation,
    secondaryVariant = PeachSchnapps,
    onSecondary = Black900,
    //text
    onPrimary = White900,
    error = Shiraz,
    onError = PigPink,
    onBackground = TransparentBlack300,
    onSurface = TransparentBlack500,

)

private val LightColorPalette = lightColors(
    primary = BilzzardBlue,
    primaryVariant = FountainBlue,
    secondary = Pippin,
    secondaryVariant = WildWatermelon,
    onSecondary = White900,
    //text
    onPrimary = Black900,
    error = Cranberry,
    onError = NightShadz,
    onBackground = TransparentWhite300,
    onSurface = TransparentWhite500,


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BookAndroidTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
package com.alibardide.composeshadow.sample.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ComposeShadowTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color.Black,
            onPrimary = Color.White,
            secondary = Color.Black,
            onSecondary = Color.White,
            tertiary = Color.Black,
            onTertiary = Color.White,
            surface = Color.White,
            onSurface = Color.Black,
            background = Color.White,
            onBackground = Color.Black
        ),
        content = content
    )
}
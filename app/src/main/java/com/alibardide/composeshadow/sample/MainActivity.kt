package com.alibardide.composeshadow.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alibardide.composeshadow.sample.ui.theme.ComposeShadowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeShadowTheme {
                MainScreen()
            }
        }
    }
}

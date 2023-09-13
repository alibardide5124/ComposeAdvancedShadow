package com.alibardide.composeshadow

import android.os.Build
import android.view.View
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Android apis below 28 wont render shadow with hardware accelaration
 * To solve this you should use [AdvancedShadowContainer] to set render mode to LAYER_TYPE_SOFTWARE
 *
 * This is necessary to use [advancedShadow] modifier
 * @param content: @Composable content to add in layer
 */
@Composable
fun AdvancedShadowContainer(content: @Composable () -> Unit) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
        AndroidView(
            factory = { context ->
                ComposeView(context).apply {
                    setLayerType(View.LAYER_TYPE_SOFTWARE, null)
                    setContent(content)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    } else {
        content()
    }
}
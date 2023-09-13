package com.alibardide.composeshadow

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Compose modifier extension function to render shadow behind layout
 * @param color: Color of the shadow
 * @param borderRadius: Border radius for rounded layout
 * @param blurRadius: Amount of shadow blur
 * @param offsetY: Set offsetY of shadow
 * @param offsetX: Set offsetX of shadow
 * @param spread: Amount of shadow spread
 * @param alpha: Its recommended to use alpha for better shadows
 *
 * @return Modifier with applied shadow
 *
 * USE IT WITH [AdvancedShadowContainer] TO PREVENT RENDER ISSUES IN ANDROID BELOW 28
 */
fun Modifier.advancedShadow(
    color: Color,
    borderRadius: Dp,
    blurRadius: Dp,
    offsetY: Dp,
    offsetX: Dp,
    spread: Dp,
    alpha: Float = 0.2f
) = this.then(
    Modifier.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            val spreadPixel = spread.toPx()
            val leftPixel = (0f - spreadPixel) + (offsetX.toPx())
            val topPixel = (0f - spreadPixel) + (offsetY.toPx())
            val rightPixel = (this.size.width + spreadPixel) + offsetX.toPx()
            val bottomPixel = (this.size.height + spreadPixel) + offsetY.toPx()

            if (blurRadius != 0.dp) {
                /*
                    The feature maskFilter used below to apply the blur effect only works
                    with hardware acceleration disabled.
                 */
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }

            frameworkPaint.color = color.copy(alpha = alpha).toArgb()
            it.drawRoundRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                radiusX = borderRadius.toPx(),
                radiusY = borderRadius.toPx(),
                paint
            )
        }
    }
)
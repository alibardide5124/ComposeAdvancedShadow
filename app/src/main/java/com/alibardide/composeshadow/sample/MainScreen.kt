package com.alibardide.composeshadow.sample

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alibardide.composeshadow.AdvancedShadowContainer
import com.alibardide.composeshadow.advancedShadow
import com.godaddy.android.colorpicker.ClassicColorPicker
import com.godaddy.android.colorpicker.HsvColor

@Composable
fun MainScreen() {
    var color by remember { mutableStateOf(Color.Black) }
    var alpha by remember { mutableFloatStateOf(.2f) }
    var borderRadius by remember { mutableFloatStateOf(12f) } 
    var blurRadius by remember { mutableFloatStateOf(2f) }
    var offsetY by remember { mutableFloatStateOf(12f) }
    var offsetX by remember { mutableFloatStateOf(12f) }
    var spread by remember { mutableFloatStateOf(2f) }

    @Composable
    fun ShadowComponentWithValues() {
        ShadowComponent(color, alpha, borderRadius, blurRadius, offsetY, offsetX, spread)
    }

    @Composable
    fun ShadowControlsWithValues() {
        ShadowControls(
            selectedColor = color,
            onPickColor = { color = it },
            alpha = alpha,
            onAlphaChange = { alpha = it },
            borderRadius = borderRadius,
            onBorderRadiusChange = { borderRadius = it },
            blurRadius = blurRadius,
            onBlurRadiusChange = { blurRadius = it },
            offsetY = offsetY,
            onOffsetYChange = { offsetY = it },
            offsetX = offsetX,
            onOffsetXChange = { offsetX = it },
            spread = spread,
            onSpreadChange = { spread = it }
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                Row(Modifier.fillMaxSize()) {
                    Box(Modifier.weight(1f)) {
                        ShadowComponentWithValues()
                    }
                    Box(Modifier.weight(1f)) {
                        ShadowControlsWithValues()
                    }
                }
            }

            else -> {
//                LazyColumn(modifier = Modifier.fillMaxSize()) {
//                    stickyHeader {
//                        ShadowComponentWithValues(
//                            Modifier
//                                .fillMaxWidth()
//
//                        )
//                    }
//                    item {
//                        ShadowControlsWithValues(Modifier)
//                    }
//                }
                Column(Modifier.fillMaxSize()) {
                    Box(Modifier.fillMaxHeight(.5f)) {
                        ShadowComponentWithValues()
                    }
                    Box(Modifier.fillMaxHeight(.5f)) {
                        ShadowControlsWithValues()
                    }
                }
            }
        }

    }
}

@Composable
private fun ShadowComponent(
    color: Color,
    alpha: Float,
    borderRadius: Float,
    blurRadius: Float,
    offsetY: Float,
    offsetX: Float,
    spread: Float
) {
    /**
     * @sample
     * Be sure to use [AdvancedShadowContainer] as parent of the view you want to apply shadow on
     */
    AdvancedShadowContainer {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                Modifier
                    .size(200.dp)
                    .padding(horizontal = 24.dp, vertical = 24.dp)
                    .advancedShadow(
                        color,
                        borderRadius.dp,
                        blurRadius.dp,
                        offsetY.dp,
                        offsetX.dp,
                        spread.dp,
                        alpha
                    )
                    .clip(RoundedCornerShape(borderRadius.dp))
                    .background(MaterialTheme.colorScheme.background)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ShadowControls(
    selectedColor: Color,
    onPickColor: (Color) -> Unit,
    alpha: Float,
    onAlphaChange: (Float) -> Unit,
    borderRadius: Float,
    onBorderRadiusChange: (Float) -> Unit,
    blurRadius: Float,
    onBlurRadiusChange: (Float) -> Unit,
    offsetY: Float,
    onOffsetYChange: (Float) -> Unit,
    offsetX: Float,
    onOffsetXChange: (Float) -> Unit,
    spread: Float,
    onSpreadChange: (Float) -> Unit
) {
    var showColorPicker by remember { mutableStateOf(false) }
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Row(Modifier.height(IntrinsicSize.Max)) {
            Button(
                onClick = { showColorPicker = true},
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(text = "Pick color")
            }
            Spacer(Modifier.width(8.dp))
            Box(
                Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(8.dp))
                    .background(selectedColor)
                    .aspectRatio(1f)
            )
        }
        ValueSlider(
            title = "Alpha",
            value = alpha,
            onValueChange = onAlphaChange,
            valueRange = 0f..1f,
        )
        ValueSlider(
            title = "Border radius",
            value = borderRadius,
            onValueChange = onBorderRadiusChange,
            valueRange = 0f..48f,
        )
        ValueSlider(
            title = "Blur radius",
            value = blurRadius,
            onValueChange = onBlurRadiusChange,
            valueRange = 0f..15f,
        )
        ValueSlider(
            title = "offsetY",
            value = offsetY,
            onValueChange = onOffsetYChange,
            valueRange = -48f..48f,
        )
        ValueSlider(
            title = "offsetX",
            value = offsetX,
            onValueChange = onOffsetXChange,
            valueRange = -48f..48f,
        )
        ValueSlider(
            title = "Spread",
            value = spread,
            onValueChange = onSpreadChange ,
            valueRange = 0f..15f,
        )
    }
    if (showColorPicker)
        ModalBottomSheet(
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
            onDismissRequest = { showColorPicker = false }
        ) {
            ClassicColorPicker(
                color = HsvColor.from(selectedColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            ) {
                onPickColor(it.toColor())
            }
        }
}

@Composable
private fun ValueSlider(
    title: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = title, fontSize = 14.sp)
        Slider(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            valueRange = valueRange,
        )
    }
}
package com.yourssu.imageselect

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
fun SvgPathLoadingIndicator(
    pathData: String,
    color: Color,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 4.dp,
    durationMillis: Int = 5_000
) {
    val path = remember(pathData) {
        try {
            PathParser().parsePathString(pathData).toPath()
        } catch (e: Exception) {
            Path()
        }
    }

    val pathMeasure = remember(path) { PathMeasure().apply { setPath(path, false) } }
    val pathLength = pathMeasure.length
    val pathBounds = remember(path) { path.getBounds() }

    val transition = rememberInfiniteTransition(label = "SvgLoader")
    val progress by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Progress"
    )

    Canvas(modifier = modifier) {
        if (pathBounds.isEmpty) return@Canvas

        val canvasWidth = size.width
        val canvasHeight = size.height

        val scaleX = canvasWidth / pathBounds.width
        val scaleY = canvasHeight / pathBounds.height
        val scale = min(scaleX, scaleY)

        val scaledWidth = pathBounds.width * scale
        val scaledHeight = pathBounds.height * scale
        val translateX = (canvasWidth - scaledWidth) / 2f - pathBounds.left * scale
        val translateY = (canvasHeight - scaledHeight) / 2f - pathBounds.top * scale

        withTransform({
            translate(translateX, translateY)
            scale(scale, scale, pivot = Offset.Zero)
        }) {
            drawPath(
                path = path,
                color = color.copy(alpha = 0.3f),
                style = Stroke(width = strokeWidth.toPx() / scale, cap = StrokeCap.Round)
            )

            val phase = pathLength * (1 - progress)
            drawPath(
                path = path,
                color = color,
                style = Stroke(
                    width = strokeWidth.toPx() / scale,
                    cap = StrokeCap.Round,
                    pathEffect = PathEffect.dashPathEffect(
                        intervals = floatArrayOf(pathLength, pathLength),
                        phase = phase
                    )
                )
            )
        }
    }
}
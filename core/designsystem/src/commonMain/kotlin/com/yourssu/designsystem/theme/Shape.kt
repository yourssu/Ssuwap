package com.yourssu.designsystem.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class WavyCircleShape(
    private val waves: Int = 6,
    private val amplitudeRatio: Float = 0.1f
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path()
        val center = Offset(size.width / 2f, size.height / 2f)
        val maxRadius = min(size.width, size.height) / 2f
        val amplitude = maxRadius * amplitudeRatio
        val baseRadius = maxRadius - amplitude

        val steps = 360
        for (i in 0..steps) {
            val angleRad = i * (PI / 180.0)
            val currentRadius = baseRadius + amplitude * sin(angleRad * waves).toFloat()

            val x = center.x + currentRadius * cos(angleRad).toFloat()
            val y = center.y + currentRadius * sin(angleRad).toFloat()

            if (i == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }
        path.close()
        return Outline.Generic(path)
    }
}
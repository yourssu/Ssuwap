package com.yourssu.imageselect

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.yourssu.designsystem.theme.WavyCircleShape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageSelectScreen() {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Ssuwap", fontWeight = FontWeight.Bold) },
                modifier = Modifier.clip(RoundedCornerShape(24.dp)),
            )
        },
        bottomBar = {
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("슝슝이로 변신!")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .drawBehind {
                        drawRoundRect(
                            color = Color(0xFF3388BD),
                            style = Stroke(
                                width = 4.dp.toPx(),
                                pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)
                            ),
                            cornerRadius = CornerRadius(24.dp.toPx())
                        )
                    }
                    .clip(RoundedCornerShape(24.dp)),
                contentAlignment = Alignment.Center
            ) {
                SelectionPlaceholder(
                    onCameraClick = { },
                    onGalleryClick = { }
                )
            }
        }
    }
}

@Composable
fun SelectionPlaceholder(onCameraClick: () -> Unit, onGalleryClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "사진을 촬영하거나\n갤러리에서 사진을 선택해주세요.",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Black, WavyCircleShape())
                .clickable(onClick = onCameraClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.PhotoCamera,
                contentDescription = "Camera",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(Modifier.height(32.dp))

        OutlinedButton(
            onClick = onGalleryClick,
        ) {
            Text("갤러리에서 사진 선택")
        }
    }
}
package com.example.fireapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Chatting(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(),){
        Column(
            modifier = modifier.fillMaxWidth().background(color = Color.Green),
           horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "GROUP CHAT", fontSize = 30.sp, )

        }
    }
    
}


@Preview
@Composable
private fun ChattingScreenPreview() {
    Chatting()
    
}
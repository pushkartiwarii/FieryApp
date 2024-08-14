package com.example.fireapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fireapp.R

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    state: AppState,
) {
    Scaffold {
        Box(
            modifier = modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedButton(onClick = {},modifier=Modifier.size(150.dp)){
                    Image(painter = painterResource(id = R.drawable.googlelogo), contentDescription = null)


                }
                Text(text = "Submit",) }
        }

    }
}



@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController(), state =AppState() )
}
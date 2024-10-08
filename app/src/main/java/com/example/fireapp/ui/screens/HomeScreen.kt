package com.example.fireapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontLoadingStrategy.Companion.Async
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.annotations.Async

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: AppState,
    userData: UserData?,
    onEvent: (AppEvent) -> Unit = {},
    onLogoutClicked: () -> Unit = {},
) {
    LaunchedEffect(true) {
        onEvent(AppEvent.OnRefreshChatList)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Fiery App") },
                actions = {
                    IconButton(onClick = onLogoutClicked) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Logout"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                OutlinedTextField(
                    value = state.message,
                    onValueChange = { onEvent(AppEvent.OnUpdateMessage(it)) },
                    label = { Text("Type your message!") },
                    modifier = Modifier.weight(8f),
                    isError = state.chatSendStatus == ChatSendStatus.ERROR,
                    supportingText = {
                        if (state.chatSendStatus == ChatSendStatus.ERROR) {
                            Text(text = state.sendingError)
                        }
                    },
                    trailingIcon = {
                        when (state.chatSendStatus) {
                            ChatSendStatus.SENDING -> {
                                CircularProgressIndicator()
                            }

                            else -> {
                                IconButton(
                                    onClick = {
                                        userData?.let {
                                            onEvent(AppEvent.OnSendEvent(userData))
                                        }
                                    },
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Default.Send,
                                        contentDescription = "send"
                                    )
                                }
                            }
                        }
                    }
                )
            }
        }
    ) {
        Column(
            modifier = modifier.padding(it)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                //reverseLayout = true
            ) {
                when (state.chatListStatus) {
                    ChatListStatus.LOADING -> {
                        item {
                            CircularProgressIndicator()
                        }
                    }

                    ChatListStatus.SUCCESS -> {
                        items(state.chatList) { msg ->
                            MessageCard(msg,userData)
                        }
                    }

                    ChatListStatus.ERROR -> {
                        item {
                            Text(
                                text = state.loadingError,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MessageCard(chatMessage: ChatMessage, userData: UserData? = null) {
    val currentUser = userData?.uid == chatMessage.userData.uid
    Row(
        modifier = Modifier.padding(8.dp)
    ) {

        Spacer(modifier = Modifier.width(8.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ){
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = chatMessage.userData.email,
                    style = MaterialTheme.typography.labelSmall
                )
                Text(text = chatMessage.message)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview () {
    HomeScreen(
        state = AppState(), userData = UserData("Robert","robert12@gmail.com","https://picsum.photos/200"),
        onLogoutClicked = {}
    )


}
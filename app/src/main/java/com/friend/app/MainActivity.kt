package com.friend.app
import androidx.compose.runtime.Composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Blue = Color(0xFF1877F2)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FriendHome()
        }
    }
}

@Composable
fun FriendHome() {
    val posts = listOf(
        "Welcome to Friend app! ❤️",
        "Connect with your friends.",
        "Share your moments with everyone!"
    )

    MaterialTheme {
        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Blue)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Friend app",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            bottomBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text("🏠 Home")
                    Text("👥 Friends")
                    Text("🔔 Alerts")
                    Text("👤 Profile")
                }
            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF0F2F5))
                    .padding(padding)
                    .padding(12.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            Text(
                                "What's on your mind?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(12.dp))
                            Button(
                                onClick = {},
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Blue
                                )
                            ) {
                                Text("Create Post")
                            }
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                }

                items(posts) { post ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            Text(
                                "Friend app",
                                fontWeight = FontWeight.Bold,
                                color = Blue
                            )
                            Spacer(Modifier.height(10.dp))
                            Text(post, fontSize = 16.sp)
                            Spacer(Modifier.height(12.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("👍 Like")
                                Text("💬 Comment")
                                Text("↗ Share")
                            }
                        }
                    }
                }
            }
        }
    }
}

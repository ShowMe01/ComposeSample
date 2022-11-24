package com.example.composesamlple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }

}

@Composable
fun Content() {
    Column(Modifier.fillMaxSize()) {
        Spacer(Modifier.weight(1f))
        Column(
            Modifier
                .fillMaxWidth()
                .height(531.dp)
                .clip(RoundedCornerShape(30.dp, 30.dp))
                .background(Color(20, 20, 20, 255))
        ) {
            Column(
                Modifier
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    .align(Alignment.CenterHorizontally)
                    .height(4.dp)
                    .width(28.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(255, 255, 255, 51))
            ) {

            }
            Text(
                text = "点赞",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )

            val likeList = listOf(
                LikeData(
                    name = "cap._.ko",
                    avatar = "https://s.momocdn.com/s1/u/ehbehgfg/test_avatar.png",
                    text = "点了一个赞",
                    icon = "https://s.momocdn.com/s1/u/ehbehgfg/emoji_like.png",
                    timeDesc = "1分钟前"
                ),
                LikeData(
                    name = "cap._.ko",
                    avatar = "https://s.momocdn.com/s1/u/ehbehgfg/test_avatar.png",
                    text = "点了一个赞",
                    icon = "https://s.momocdn.com/s1/u/ehbehgfg/emoji_like.png",
                    timeDesc = "1分钟前"
                ),
                LikeData(
                    name = "cap._.ko",
                    avatar = "https://s.momocdn.com/s1/u/ehbehgfg/test_avatar.png",
                    text = "点了一个赞",
                    icon = "https://s.momocdn.com/s1/u/ehbehgfg/emoji_like.png",
                    timeDesc = "1分钟前"
                )
            )
            LazyColumn(Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)) {
                items(likeList) { data ->
                    Row(Modifier.padding(bottom = 25.dp)) {
                        Image(
                            rememberImagePainter(data.avatar),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 15.dp, end = 7.5.dp)
                                .size(40.dp)
                                .clip(CircleShape)
                        )
                        Column(Modifier.fillMaxWidth()) {
                            Text(
                                text = data.name,
                                fontSize = 13.sp,
                                color = Color(1f, 1f, 1f, 0.4f)
                            )
                            Row(
                                Modifier
                                    .offset(y = (-4.5f).dp)
                                    .height(24.dp)
                                    .background(Color.Red)
                            ) {
                                Text(
                                    text = data.text,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                                Image(
                                    rememberImagePainter(data.icon), contentDescription = null,
                                    Modifier
                                        .size(24.dp)
                                        .align(Alignment.CenterVertically)
                                )
                            }
                            Text(
                                text = data.timeDesc,
                                fontSize = 13.sp,
                                color = Color(1f, 1f, 1f, 1f * 0.4f),
                                modifier = Modifier.background(Color.Blue)                                    .offset(y = (-4.5f).dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

data class LikeData(
    val name: String,
    val avatar: String,
    var text: String,
    var icon: String,
    val timeDesc: String
)

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun PreviewGreeting() {
    Content()
}
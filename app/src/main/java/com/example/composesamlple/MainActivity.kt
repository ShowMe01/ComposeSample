package com.example.composesamlple

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Content()
//            Tip(text = "能发给同学啦~")
            ClickText()
        }
    }

}

@SuppressLint("UnrememberedMutableState")
@Composable
fun ClickText() {
    var time by mutableStateOf(1)
    Column(Modifier.fillMaxWidth()) {
        Button(onClick = {
            time++
        }, modifier = Modifier.align(Alignment.CenterHorizontally)
            .width(80.dp)) {
            Text(
                text = time.toString(),
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
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
            TopBar()
            PageTitle("点赞")
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
                                modifier = Modifier
                                    .background(Color.Blue)
                                    .offset(y = (-4.5f).dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TopBar() {
    Column(Modifier.fillMaxWidth()) {
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
    }
}

@Composable
private fun PageTitle(title: String) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 15.dp),
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun Tip(text: String) {
    Box(Modifier.fillMaxWidth()) {
        Image(
            rememberImagePainter("https://s.momocdn.com/s1/u/ehbehgfg/tip_bg.png"),
            contentDescription = null,
            Modifier
                .align(Alignment.Center)
                .width(140.dp)
                .height(49.dp)
        )

        Box(
            Modifier
                .align(Alignment.Center)
                .width(140.dp)
                .height(49.dp)
                .padding(bottom = 4.dp)
        ) {
            Text(
                text = text,
                modifier = Modifier.align(Alignment.Center),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
            )
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
//    Content()
//    Tip(text = "能发给同学啦~")
    ClickText()
}
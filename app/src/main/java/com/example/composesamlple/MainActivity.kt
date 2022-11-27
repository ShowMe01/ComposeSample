package com.example.composesamlple

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val urls = listOf("u", "u", "url")
            var index by remember {
                mutableStateOf(0)
            }
            Column(modifier = Modifier
                .width(100.dp)
                .height(50.dp)
                .background(Color.Blue)
                .clickable {
                    Log.d("testRemember", "before click index:${index}")
                    index = (index + 1) % 3
                    Log.d("testRemember", "after click index:${index}")
                }) {
                Log.d("testRemember", "before ShowResponseLength index:${index}")
                ShowResponseLength(url = urls[index], index = index)
                Log.d("testRemember", "after ShowResponseLength index:${index}")
            }
        }
    }

    @Composable
    private fun ShowResponseLength(url: String, index: Int) {
        // 假设这步是在做网络请求，很耗资源
        Log.d("testRemember", "ShowResponseLength url:${url}")
        val length = remember(url) {
            getUrlLength(url)
        }
        Text(text = length.toString())
    }

    private fun getUrlLength(url: String): Int {
        Log.d("testRemember", "getUrlLength url:${url}")
        return url.length
    }

    @Composable
    private fun Content() {
        Column(Modifier.fillMaxWidth()) {
            var time by remember { mutableStateOf(0) }
            Text(
                text = time.toString(),
                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp)
                    .background(Color.Blue)
                    .clickable {
                        time++
                    },
                color = Color.White,
            )
        }
    }

}
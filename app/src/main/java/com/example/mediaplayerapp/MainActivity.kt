package com.example.mediaplayerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mediaplayerapp.ui.theme.MediaPlayerAppTheme
import com.example.mediaplayerapp.ui.videoplayer.VideoPlayerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaPlayerAppTheme {
                VideoPlayerScreen()
            }
        }
    }
}

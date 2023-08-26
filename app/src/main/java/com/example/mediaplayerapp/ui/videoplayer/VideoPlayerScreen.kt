package com.example.mediaplayerapp.ui.videoplayer

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayerScreen(
    modifier: Modifier = Modifier
) {
    val context: Context = LocalContext.current
    val exoPlayer: ExoPlayer = remember {
        ExoPlayer.Builder(context).build()
            .apply {
                setMediaItem(
                    MediaItem.Builder()
                        .setUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4")
                        .build()
                )
                prepare()
                playWhenReady = true
            }
    }

    DisposableEffect(Unit) {
        onDispose {
            Log.d("OnDispose", "DisposableEffect Called")
            exoPlayer.release()
        }
    }



    Surface {
        Box(
            modifier = modifier
        ) {
            AndroidView(
                factory = {
                    PlayerView(context).apply {
                        player = exoPlayer
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(16 / 9f)
            )
        }
    }
}
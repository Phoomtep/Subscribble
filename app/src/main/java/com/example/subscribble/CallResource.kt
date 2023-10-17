package com.example.subscribble

import androidx.compose.ui.graphics.Color

fun getDrawableResource(inputString: String): Int {
    return when (inputString) {
        "Netflix" -> R.drawable.netflix
        "Apple TV" -> R.drawable.appletv
        "Youtube" -> R.drawable.youtube
        "Disney Plus" -> R.drawable.disneyplus

        "Apple Music" -> R.drawable.applemusic
        "Spotify" -> R.drawable.spotify
        "Youtube Music" -> R.drawable.youtubemusic
        else -> R.drawable.something_went_wrong
    }
}

fun classify(inputString: String): String {
    return when (inputString) {
        "Netflix" -> "video"
        "Apple TV" -> "video"
        "Youtube" -> "video"
        "Disney Plus" -> "video"

        "Apple Music" -> "music"
        "Spotify" -> "music"
        "Youtube Music" -> "music"
        else -> "error"
    }
}

fun getApplicationColor(inputString: String): Color {
    return when (inputString){
        "Netflix" -> Color(0xFFAB060F)
        "Apple TV" -> Color(0xFF2D2D2D)
        "Youtube" -> Color(0xFFF70000)
        "Disney Plus" -> Color(0xFF0060DE)

        "Apple Music" -> Color(0xFFF74F6B)
        "Spotify" -> Color(0xFF1BC357)
        "Youtube Music" -> Color(0xFFF70000)

        else -> Color.White
    }
}

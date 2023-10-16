package com.example.subscribble

import androidx.compose.ui.graphics.Color

fun getDrawableResource(inputString: String): Int {
    return when (inputString) {
        "netflix" -> R.drawable.netflix
        "appletv" -> R.drawable.appletv
        "youtube" -> R.drawable.youtube
        "disneyplus" -> R.drawable.disneyplus

        "applemusic" -> R.drawable.applemusic
        "spotify" -> R.drawable.spotify
        "youtubemusic" -> R.drawable.youtubemusic
        else -> R.drawable.something_went_wrong
    }
}

fun classify(inputString: String): String {
    return when (inputString) {
        "netflix" -> "video"
        "appletv" -> "video"
        "youtube" -> "video"
        "disneyplus" -> "video"

        "applemusic" -> "music"
        "spotify" -> "music"
        "youtubemusic" -> "music"
        else -> ""
    }
}

fun getApplicationColor(inputString: String): Color {
    return when (inputString){
        "netflix" -> Color(0xFFAB060F)
        "appletv" -> Color(0xFF2D2D2D)
        "youtube" -> Color(0xFFF70000)
        "disneyplus" -> Color(0xFF0060DE)

        "applemusic" -> Color(0xFFF74F6B)
        "spotify" -> Color(0xFF1BC357)
        "youtubemusic" -> Color(0xFFF70000)

        else -> Color.White
    }
}

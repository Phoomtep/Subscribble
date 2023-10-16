package com.example.subscribble

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
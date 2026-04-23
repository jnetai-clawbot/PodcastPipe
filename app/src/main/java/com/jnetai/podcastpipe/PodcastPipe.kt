package com.jnetai.podcastpipe

import android.app.Application
import com.jnetai.podcastpipe.data.PodcastPipeDatabase

class PodcastPipe : Application() {
    val database by lazy { PodcastPipeDatabase.getInstance(this) }
}
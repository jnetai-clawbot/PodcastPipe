package com.jnetai.podcastpipe.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jnetai.podcastpipe.model.*

@Database(entities = [Episode::class, Stage::class, Guest::class], version = 1, exportSchema = false)
abstract class PodcastPipeDatabase : RoomDatabase() {
    abstract fun dao(): PodcastPipeDao
    companion object {
        @Volatile private var INSTANCE: PodcastPipeDatabase? = null
        fun getInstance(context: Context): PodcastPipeDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context, PodcastPipeDatabase::class.java, "podcastpipe.db")
                .fallbackToDestructiveMigration().build().also { INSTANCE = it }
        }
    }
}
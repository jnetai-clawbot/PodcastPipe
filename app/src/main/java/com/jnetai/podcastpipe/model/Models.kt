package com.jnetai.podcastpipe.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(tableName = "episodes", indices = [Index("title")])
data class Episode(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String = "",
    val series: String = "",
    val episodeNumber: Int = 0,
    val status: String = "Planned",
    val guestName: String = "",
    val guestEmail: String = "",
    val recordingDate: String = "",
    val duration: Int = 0,
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "stages", indices = [Index("episodeId")])
data class Stage(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val episodeId: Long,
    val name: String,
    val orderIndex: Int = 0,
    val isCompleted: Boolean = false,
    val notes: String = "",
    val completedAt: Long = 0
)

@Entity(tableName = "guests", indices = [Index("name")])
data class Guest(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val email: String = "",
    val bio: String = "",
    val socialLinks: String = "",
    val appearances: Int = 0,
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)
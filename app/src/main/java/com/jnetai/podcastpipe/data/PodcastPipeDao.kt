package com.jnetai.podcastpipe.data

import androidx.room.*
import com.jnetai.podcastpipe.model.Episode
import com.jnetai.podcastpipe.model.Stage
import com.jnetai.podcastpipe.model.Guest

@Dao
interface PodcastPipeDao {
    @Query("SELECT * FROM episodes ORDER BY createdAt DESC") suspend fun getAllEpisodes(): List<Episode>
    @Query("SELECT * FROM episodes WHERE id = :id") suspend fun getEpisode(id: Long): Episode?
    @Insert suspend fun insertEpisode(episode: Episode): Long
    @Update suspend fun updateEpisode(episode: Episode)
    @Delete suspend fun deleteEpisode(episode: Episode)

    @Query("SELECT * FROM stages WHERE episodeId = :episodeId ORDER BY orderIndex") suspend fun getStagesForEpisode(episodeId: Long): List<Stage>
    @Insert suspend fun insertStage(stage: Stage): Long
    @Update suspend fun updateStage(stage: Stage)
    @Delete suspend fun deleteStage(stage: Stage)

    @Query("SELECT * FROM guests ORDER BY createdAt DESC") suspend fun getAllGuests(): List<Guest>
    @Query("SELECT * FROM guests WHERE id = :id") suspend fun getGuest(id: Long): Guest?
    @Insert suspend fun insertGuest(guest: Guest): Long
    @Update suspend fun updateGuest(guest: Guest)
    @Delete suspend fun deleteGuest(guest: Guest)
}
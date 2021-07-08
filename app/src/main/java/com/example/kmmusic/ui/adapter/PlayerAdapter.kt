package com.example.kmmusic.ui.adapter

import android.media.MediaPlayer
import com.example.kmmusic.data.model.Song
import com.example.kmmusic.util.PlaybackInfoListener

interface PlayerAdapter {
    fun isMediaPlayer(): Boolean

    fun isPlaying(): Boolean

    fun isReset(): Boolean

    fun getCurrentSong(): Song?

    @PlaybackInfoListener.State
    fun getState(): Int

    fun getPlayerPosition(): Int

    fun getMediaPlayer(): MediaPlayer?

    fun initMediaPlayer()

    fun release()

    fun resumeOrPause()

    fun reset()

    fun instantReset()

    fun skip(isNext: Boolean)

    fun seekTo(position: Int)

    fun setPlaybackInfoListener(playbackInfoListener: PlaybackInfoListener)

    fun registerNotificationActionsReceiver(isRegister: Boolean)

    fun setCurrentSong(song: Song, songs: List<Song>)

    fun onPauseActivity()

    fun onResumeActivity()
}

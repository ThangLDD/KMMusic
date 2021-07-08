package com.example.kmmusic.data.local

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kmmusic.R
import com.example.kmmusic.data.SongProvider
import com.example.kmmusic.data.model.Song
import com.example.kmmusic.ui.adapter.RecylerAdapter
import kotlinx.android.synthetic.main.content_main.*

abstract class GetSongsData : AppCompatActivity(), RecylerAdapter.SongClicked {

    private var songAdapter: RecylerAdapter? = null
    private var deviceMusic = mutableListOf<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songAdapter = RecylerAdapter()
        setViews()
    }

    private fun setViews() {
        songAdapter?.setOnSongClicked(this)

        recyclerView.apply {
            adapter = songAdapter
            layoutManager = LinearLayoutManager(this@GetSongsData)
            hasFixedSize()
        }
    }

    fun getMusic() {
        deviceMusic.addAll(SongProvider.getAllDeviceSongs(this))
        songAdapter?.addSongs(deviceMusic)
    }
}
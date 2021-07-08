package com.example.kmmusic.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import com.example.kmmusic.R
import java.io.ByteArrayInputStream
import java.io.InputStream


object Utils {

    fun songArt(path: String, context: Context): Bitmap {
        val retriever = MediaMetadataRetriever()
        val inputStream: InputStream

        retriever.setDataSource(path)
        return if (retriever.embeddedPicture != null) {
            inputStream = ByteArrayInputStream(retriever.embeddedPicture)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            retriever.release()
            bitmap
        } else {
            getLargeIcon(context)
        }
    }

    private fun getLargeIcon(context: Context): Bitmap {
        return BitmapFactory.decodeResource(context.resources, R.drawable.icon_music)
    }
}

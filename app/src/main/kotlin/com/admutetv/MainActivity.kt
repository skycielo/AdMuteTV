package com.admutetv

import android.app.Activity
import android.media.AudioManager
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {
    private lateinit var audioManager: AudioManager
    private var isMuted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager

        val muteButton: Button = findViewById(R.id.muteButton)
        muteButton.setOnClickListener {
            isMuted = !isMuted
            audioManager.adjustStreamVolume(
                AudioManager.STREAM_MUSIC,
                if (isMuted) AudioManager.ADJUST_MUTE else AudioManager.ADJUST_UNMUTE,
                0
            )
            muteButton.text = if (isMuted) "Unmute" else "Mute"
        }
    }
}

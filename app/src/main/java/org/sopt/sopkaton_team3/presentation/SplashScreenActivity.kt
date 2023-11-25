package org.sopt.sopkaton_team3.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sopkaton_team3.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.splash_video)

        videoView.setVideoURI(uri)
        videoView.start()

        videoView.setOnCompletionListener {
            // 비디오 재생이 끝나면 메인 액티비티로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // 스플래시 스크린 액티비티 종료
        }
    }
}
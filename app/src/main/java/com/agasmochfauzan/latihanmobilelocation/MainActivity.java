package com.agasmochfauzan.latihanmobilelocation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Langkah 1 Buat VideoView
        videoView = findViewById(R.id.videoView);
        //Langkah 2 Gunakan MediaController sebagai viewoView
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    public void play(View view) {
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("https://demonuts.com/Demonuts/smallvideo.mp4"));
        videoView.requestFocus();
        videoView.start();

    }
}

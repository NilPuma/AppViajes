package com.example.ventaboletos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class verPuno extends AppCompatActivity
{
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_puno);
        getSupportActionBar().setTitle("PUNO");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Seccion del video

        videoView=(VideoView)findViewById(R.id.videoPuno);
        String videoPath="android.resource://"+getPackageName()+"/"+R.raw.puno;
        Uri uri=Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        //
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }
    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return false;
    }
}

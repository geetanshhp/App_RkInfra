package com.rkinfraContruction.rkinfra;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Follow extends AppCompatActivity
{
    ImageButton Finstagram,Ffacebook,Ftwitter,Flinkedin,googleP;
    Button button;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        Finstagram = findViewById(R.id.instagram);
        googleP=findViewById(R.id.FGoogleP);
        Ffacebook = findViewById(R.id.facebook);
        Ftwitter = findViewById(R.id.twitter);
        Flinkedin = findViewById(R.id.linkedid);
        button = findViewById(R.id.cardbutton);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        back = findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Follow.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://rkinfra.in/"));
                startActivity(intent);

            }
        });
        Finstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FollowInsta();

            }
        });
        Ffacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FollowFace();

            }
        });
        googleP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FollowGp();


            }
        });
        Ftwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FollowTwitter();

            }
        });
        Flinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FollowLinked();


            }
        });

    }

    private void FollowLinked()
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://rkinfra.in/"));
        startActivity(intent);
    }

    private void FollowTwitter()
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://rkinfra.in/"));
        startActivity(intent);
    }

    private void FollowGp()
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://rkinfra.in/"));
        startActivity(intent);
    }

    private void FollowInsta()
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.instagram.com/rkinfra/"));
        startActivity(intent);
    }
    private void FollowFace()
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/rkinfrai/"));
        startActivity(intent);
    }
}


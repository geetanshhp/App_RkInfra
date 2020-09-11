package com.rkinfraContruction.rkinfra;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    CardView aboutmyself,service,contact_us,follow_us,share_us,myproducts,mision,vision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        aboutmyself=findViewById(R.id.idaboutmyself);
        service=findViewById(R.id.idServices);
        contact_us=findViewById(R.id.idContatcUs);
        follow_us=findViewById(R.id.idFollow_us);
        share_us=findViewById(R.id.idshare);
        myproducts=findViewById(R.id.idourproducts);
        mision=findViewById(R.id.idMissionCard);
        vision=findViewById(R.id.idVisionCard);
        onclickCardVie();
    }

    private void onclickCardVie()
    {
        share_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String s="https://play.google.com/store/apps/details?id=com.rkinfraContruction.rkinfra&hl=en";
                intent.putExtra(Intent.EXTRA_TEXT,s);
                startActivity(Intent.createChooser(intent,"Share Via"));

            }
        });
        mision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,Mission_Activity.class);
                startActivity(intent);

            }
        });
        vision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,Vision_Activity.class);
                startActivity(intent);

            }
        });
        aboutmyself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,About_Us.class);
                startActivity(intent);
            }
        });
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,Services.class);
                startActivity(intent);

            }
        });
        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,Contact_Us.class);
                startActivity(intent);

            }
        });
        myproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             Intent intent=new Intent(MainActivity.this,Our_Projects.class);
             startActivity(intent);
            }
        });
        follow_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,Follow.class);
                startActivity(intent);

            }
        });
    }
    @Override
    public void onBackPressed()
    {


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("CONFRIM EXIT");
            builder.setIcon(R.drawable.cross);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
        }
    }


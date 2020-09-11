package com.rkinfraContruction.rkinfra;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Retrofitting extends AppCompatActivity
{
    TextView p1,p2,p3,p4;
    ProgressDialog dialog;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference pone=database.getReference("RetroFitting/P1");
    DatabaseReference ptwo=database.getReference("RetroFitting/P2");
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofitting);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        p1=findViewById(R.id.id_p1);
        p2=findViewById(R.id.id_p2);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Please Wait");
        dialog.setMessage("Data is being Loaded");
        dialog.show();
        GetText();
    }

    private void GetText()
    {
        pone.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                p1.setText(s);
                dialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        ptwo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s1=dataSnapshot.getValue(String.class);
                p2.setText(s1);
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

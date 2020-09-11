package com.rkinfraContruction.rkinfra;

import android.app.ProgressDialog;
import android.content.SyncRequest;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class Construction extends AppCompatActivity
{
    TextView Defination,t1,t2,t3,t4;
    ImageView imageView1,imageView2,imageView3,imageView4;
    ProgressDialog progressDialog;
    FirebaseStorage storage;
    StorageReference reference;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference definationP=database.getReference("Contruction/Defination");
    DatabaseReference p1=database.getReference("Contruction/P1");
    DatabaseReference p2=database.getReference("Contruction/P2");
    DatabaseReference p3=database.getReference("Contruction/P3");
    DatabaseReference p4=database.getReference("Contruction/P4");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_construction);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Defination=findViewById(R.id.id_Definnation);
        t1=findViewById(R.id.idp1);
        t2=findViewById(R.id.idp2);
        t3=findViewById(R.id.idp3);
        t4=findViewById(R.id.idp4);
        imageView1=findViewById(R.id.id_image1);
        imageView2=findViewById(R.id.id_image2);
        imageView3=findViewById(R.id.id_image3);
        imageView4=findViewById(R.id.id_image4);
        FetchText();
        FetchImage();
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Data is being loading ");
        progressDialog.show();
    }

    private void FetchImage()
    {
        storage=FirebaseStorage.getInstance();
        reference=storage.getReferenceFromUrl("gs://rkinfra-b3b45.appspot.com/");
        StorageReference fisrt=reference.child("building.png");
        File myfile=null;
        try
        {
            myfile=File.createTempFile("images",".png");
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        final File finalmyfile1=myfile;
        fisrt.getFile(myfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalmyfile1.getAbsolutePath());
                imageView1.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });
        StorageReference second=reference.child("heavy.png");
        File myfile2=null;
        try
        {

                myfile2=File.createTempFile("images",".png");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfilefile2=myfile2;
        second.getFile(myfile2).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfilefile2.getAbsolutePath());
                imageView2.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {


            }
        });
        StorageReference third=reference.child("water.png");
        File myfile3=null;
        try {
            myfile3=File.createTempFile("images",".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final  File finalfile3=myfile3;
        third.getFile(myfile3).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile3.getAbsolutePath());
                imageView3.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });



        StorageReference four=reference.child("interiors.png");
        File myfile4=null;
        try {
            myfile4=File.createTempFile("images",".png");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile4=myfile4;
        four.getFile(myfile4).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile4.getAbsolutePath());
                imageView4.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });


    }

    private void FetchText()
    {
        definationP.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                Defination.setText(s);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        p1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                t1.setText(s);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    p2.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot)
        {
            String s=dataSnapshot.getValue(String.class);
            t2.setText(s);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    p3.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot)
        {
            String s=dataSnapshot.getValue(String.class);
            t3.setText(s);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    p4.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot)
        {
            String s=dataSnapshot.getValue(String.class);
            t4.setText(s);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    }
}

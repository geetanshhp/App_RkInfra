package com.rkinfraContruction.rkinfra;

import android.app.ProgressDialog;
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

public class Ndt extends AppCompatActivity
{
    TextView Defination,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11;
    ProgressDialog progressDialog;
    FirebaseStorage storage;
    StorageReference reference;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference definationP=database.getReference("Ndt/Defination");
    DatabaseReference p1=database.getReference("Ndt/P1");
    DatabaseReference p2=database.getReference("Ndt/P2");
    DatabaseReference p3=database.getReference("Ndt/P3");
    DatabaseReference p4=database.getReference("Ndt/P4");
    DatabaseReference p5=database.getReference("Ndt/P5");
    DatabaseReference p6=database.getReference("Ndt/P6");
    DatabaseReference p7=database.getReference("Ndt/P7");
    DatabaseReference p8=database.getReference("Ndt/P8");
    DatabaseReference p9=database.getReference("Ndt/P9");
    DatabaseReference p10=database.getReference("Ndt/P10");
    DatabaseReference p11=database.getReference("Ndt/P11");
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndt);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        t1=findViewById(R.id.idp1);
        Defination=findViewById(R.id.id_Definnation);
        t2=findViewById(R.id.idp2);
        t3=findViewById(R.id.idp3);
        t4=findViewById(R.id.idp4);
        t5=findViewById(R.id.idp5);
        t6=findViewById(R.id.idp6);
        t7=findViewById(R.id.idp7);
        t8=findViewById(R.id.idp8);
        t9=findViewById(R.id.idp9);
        t10=findViewById(R.id.idp10);
        t11=findViewById(R.id.idp11);
        imageView1=findViewById(R.id.id_image1);
        imageView2=findViewById(R.id.id_image2);
        imageView3=findViewById(R.id.id_image3);
        imageView4=findViewById(R.id.id_image4);
        imageView5=findViewById(R.id.id_image5);
        imageView6=findViewById(R.id.id_image6);
        imageView7=findViewById(R.id.id_image7);
        imageView8=findViewById(R.id.id_image8);
        imageView9=findViewById(R.id.id_image9);
        imageView10=findViewById(R.id.id_image10);
        imageView11=findViewById(R.id.id_image11);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Data is being loading ");
        progressDialog.show();

        GerText();
        GetImage();

    }

    private void GetImage()
    {
        storage=FirebaseStorage.getInstance();
        reference=storage.getReferenceFromUrl("gs://rkinfra-b3b45.appspot.com/");
        StorageReference fisrt=reference.child("ndtstructural.png");
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
        StorageReference second=reference.child("ndtsteel.png");
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
        StorageReference third=reference.child("ndtinjection.png");
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



        StorageReference four=reference.child("ndtfrcc.png");
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
        StorageReference five = reference.child("ndtmetal.png");
        File myfile5=null;
        try {
            myfile5=File.createTempFile("images",".png");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile5=myfile5;
        five.getFile(myfile5).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile5.getAbsolutePath());
                imageView5.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });


        StorageReference six = reference.child("ndtpipelene.png");
        File myfile6=null;
        try {
            myfile6=File.createTempFile("images",".png");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile6=myfile6;
        six.getFile(myfile6).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile6.getAbsolutePath());
                imageView6.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });


        StorageReference seven=reference.child("ndtepoxy.png");
        File myfile7=null;
        try
        {
            myfile7=File.createTempFile("images",".png");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        final File finalmyfile7=myfile7;
        seven.getFile(myfile7).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalmyfile7.getAbsolutePath());
                imageView7.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        StorageReference eight=reference.child("ndtstrengthing.png");
        File myfile8=null;
        try
        {
            myfile8=File.createTempFile("images",".png");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile8=myfile8;
        eight.getFile(myfile8).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile8.getAbsolutePath());
                imageView8.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });
        StorageReference nine=reference.child("ndtprotecting.png");
        File myfile9=null;
        try
        {
            myfile9=File.createTempFile("images",".png");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile9=myfile9;
        nine.getFile(myfile9).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile9.getAbsolutePath());
                imageView9.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        StorageReference ten=reference.child("ndtsilicon.png");
        File myfile10=null;
        try
        {
            myfile10=File.createTempFile("images",".png");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile10=myfile10;
        ten.getFile(myfile10).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile10.getAbsolutePath());
                imageView10.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        StorageReference eleven=reference.child("ndtconcrete.png");
        File myfile11=null;
        try
        {
            myfile11=File.createTempFile("images",".png");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile11=myfile11;
        eleven.getFile(myfile11).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile11.getAbsolutePath());
                imageView11.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });
    }

    private void GerText()
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
        p5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                t5.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        p6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                t6.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        p7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                t7.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        p8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);
                t8.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        p9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                t9.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        p10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);
                t10.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        p11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);
                t11.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

package com.rkinfraContruction.rkinfra;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.logging.StreamHandler;

public class Contact_Us extends AppCompatActivity
{
    ProgressDialog progressDialog;
    FloatingActionButton floatingActionButton,floatcall1,floatcall2;
    String stringmail1,stringmail2,stringmail3,stringph1,stringph2,stringadddress;
    TextView add,email1,email2,email3,ph1,ph2;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference address= database.getReference("Contact_Us/Address");
    DatabaseReference mail1=database.getReference("Contact_Us/Email1");
    DatabaseReference mail2=database.getReference("Contact_Us/Email2");
    DatabaseReference mail3=database.getReference("Contact_Us/Email3");
    DatabaseReference phone1=database.getReference("Contact_Us/Phone1");
    DatabaseReference phone2=database.getReference("Contact_Us/Phone2");



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        add=findViewById(R.id.idlocation);
        email1=findViewById(R.id.idmail1);
        email2=findViewById(R.id.idmail2);
        email3=findViewById(R.id.idemail3);
        ph1=findViewById(R.id.idphone1);
        ph2=findViewById(R.id.idphone2);
        floatcall1=findViewById(R.id.floatingcall1);
        floatcall2=findViewById(R.id.floatingcall2);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Data is being loading ");
        progressDialog.show();
        floatingActionButton=findViewById(R.id.floatingShare);
        GetText();
        floatcall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                makephone1();
            }
        });
        floatcall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                makephone2();

            }
        });
        ph1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                makephone2();
            }
        });
        ph2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                makephone1();
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String v1="WE CAN HELP BUILD YOUR PROJECT! \nTELL US ABOUT YOUR PROJECT:\n Rkinfra \n Mobile 1 :"+ stringph1+ "\n Mobile 2:" + stringph2 +" \n Mail 1: "+ stringmail1+" \n Mail 2:"+ stringmail2 +"\n Mail 3: "+stringmail3  +"\nAddress: "+stringadddress;                                   ;
                intent.putExtra(Intent.EXTRA_TEXT,v1);
                //intent.putExtra(Intent.EXTRA_TEXT,v1);
                startActivity(Intent.createChooser(intent,"Share Via"));

            }
        });
    }


    private void GetText()
    {
        address.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               stringadddress=dataSnapshot.getValue(String.class);
               add.setText(stringadddress);
               progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mail1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                stringmail1=dataSnapshot.getValue(String.class);
                email1.setText(stringmail1);
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mail2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                stringmail2=dataSnapshot.getValue(String.class);
                email2.setText(stringmail2);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mail3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                stringmail3=dataSnapshot.getValue(String.class);
                email3.setText(stringmail3);
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        phone1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                stringph1=dataSnapshot.getValue(String.class);
                ph1.setText(stringph1);
                progressDialog.dismiss();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        phone2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stringph2=dataSnapshot.getValue(String.class);
                ph2.setText(stringph2);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void makephone2()
    {

        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:9891650790"));
        startActivity(i);
    }

    private void makephone1()
    {
        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:+91 - 120 - 2412637"));
        startActivity(i);

    }
}

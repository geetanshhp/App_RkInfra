package com.rkinfraContruction.rkinfra;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Services extends AppCompatActivity
{
    CardView consrtuction,acp,facade_Work,retrofitting,waterProffing,ndt,glass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        consrtuction=findViewById(R.id.idconstruction);
        acp=findViewById(R.id.idAsp);
        facade_Work=findViewById(R.id.idFacade_Work);
        retrofitting=findViewById(R.id.idretrofitting);
        waterProffing=findViewById(R.id.idwaterproofing);
        ndt=findViewById(R.id.idNdt);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        glass=findViewById(R.id.idglassclening);
        onclickCardView();
    }

    private void onclickCardView()
    {
        glass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Services.this,Glass_Cleaning.class);
                startActivity(intent);

            }
        });
        consrtuction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Services.this,Construction.class);
                startActivity(intent);

            }
        });
        acp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Services.this,Acp.class);
                startActivity(intent);

            }
        });
        facade_Work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Services.this,Facade_Work.class);
                startActivity(intent);

            }
        });
        retrofitting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Services.this, Retrofitting.class);
                startActivity(intent);
            }
        });
        waterProffing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Services.this,WaterProofing.class);
                startActivity(intent);
            }
        });
        ndt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Services.this,Ndt.class);
                startActivity(intent);
            }
        });
    }
}

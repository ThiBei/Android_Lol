package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityResultat extends AppCompatActivity {


    private TextView textView;
    private Button btnSend;
    private TextView txtMail;
    private ImageView imgChampion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        textView = findViewById(R.id.textView);
        txtMail = findViewById(R.id.txtMail);
        imgChampion = findViewById(R.id.imgChampion);
        imgChampion.setImageResource(R.drawable.gnar_classic);

        textView.setText(calculResulat());

        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtMail.getText().toString().equals(""))
                sendMail();
            }
        });

    }

    private String calculResulat(){

        int top=0;
        int jungle=0;
        int mid=0;
        int bot=0;

        String resQ1 = getIntent().getStringExtra("Q1");//ce définire
        String resQ2 = getIntent().getStringExtra("Q2");//Comment vivre
        String resQ3 = getIntent().getStringExtra("Q3");// Quelle région
        String resQ4 = getIntent().getStringExtra("Q4");//lors d'un comabt (multi Choice)
        String[] partsQ4 = resQ4.split("-");
        String resQ5 = getIntent().getStringExtra("Q5");//arme
        String resQ6 = getIntent().getStringExtra("Q6");//comboBox

        if(resQ2.equals("1")){
            top=top+1;
        }else if(resQ2.equals("2")){
            jungle=jungle+1;
        }else if(resQ2.equals("3")){
            mid=mid+1;
        }else { //4
            bot=bot+1;
        }




        return "t'es le boss";
    }

    private void sendMail(){
        String mail = txtMail.getText().toString();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{mail});
        i.putExtra(Intent.EXTRA_SUBJECT, "Results");//objet
        i.putExtra(Intent.EXTRA_TEXT   , "Voici les résultats de votre GPHY test :\n\n" +"blabla");//corps
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityResultat extends AppCompatActivity {


    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        textView = findViewById(R.id.textView);

        textView.setText(calculResulat());


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
}
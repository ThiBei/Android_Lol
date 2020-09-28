package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityQuestion4 extends AppCompatActivity {

    private TextView textView;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private Button btnGauche;
    private Button btnDroit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);


        textView= findViewById(R.id.textView);

        checkBox1= findViewById(R.id.checkBox1);
        checkBox2= findViewById(R.id.checkBox2);
        checkBox3= findViewById(R.id.checkBox3);
        checkBox4= findViewById(R.id.checkBox4);

        btnGauche= findViewById(R.id.btnGauche);
        btnDroit= findViewById(R.id.btnDroit);

        btnGauche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        btnDroit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext();
            }
        });

    }




    public void goBack(){
        this.finish();
    }

    public void goNext(){
        String res="";

        if(checkBox1.isChecked()){
            res=res+"rep1-";
        }
        if(checkBox2.isChecked()){
            res=res+"rep2-";
        }
        if(checkBox3.isChecked()){
            res=res+"rep3-";
        }
        if(checkBox4.isChecked()){
            res=res+"rep4-";
        }


        if(!res.equals("")) {
            Intent intent = new Intent(this, ActivityQuestion4.class);
            intent.putExtra("Q1", getIntent().getStringExtra("Q1"));
            intent.putExtra("Q2", getIntent().getStringExtra("Q2"));
            intent.putExtra("Q3", getIntent().getStringExtra("Q3"));
            intent.putExtra("Q4", res);
            Toast toasti = Toast.makeText(getApplicationContext(), res,Toast.LENGTH_SHORT);
            toasti.show();
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Choisir au moins un choix",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
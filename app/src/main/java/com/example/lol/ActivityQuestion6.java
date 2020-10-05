package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityQuestion6 extends AppCompatActivity {

    private Spinner spin;
    private Button btnGauche;
    private Button btnDroit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);

        spin = findViewById(R.id.spin);
        spin.setSelection(0);

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

        String var = "";
        var=spin.getSelectedItem().toString();

        Toast toast = Toast.makeText(getApplicationContext(), var,Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this, ActivityResultat.class);
        intent.putExtra("Q1", getIntent().getStringExtra("Q1"));
        intent.putExtra("Q2", getIntent().getStringExtra("Q2"));
        intent.putExtra("Q3", getIntent().getStringExtra("Q3"));
        intent.putExtra("Q4", getIntent().getStringExtra("Q4"));
        intent.putExtra("Q5", getIntent().getStringExtra("Q5"));
        intent.putExtra("Q6", var);
        startActivity(intent);
    }

}
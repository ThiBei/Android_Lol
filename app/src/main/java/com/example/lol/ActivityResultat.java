package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class ActivityResultat extends AppCompatActivity {


    private TextView textView;
    private Button btnSend;
    private TextView txtMail;
    private ImageView imgChampion;

    int top=0;
    int jungle=0;
    int mid=0;
    int adc=0;
    int supp=0;

    int bundle=0;
    int bilgwater=0;
    int targon=0;
    int ionia=0;
    int demacia=0;
    int noxus=0;
    int shurima=0;
    int freljord=0;
    int piltover=0;


    int error=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        textView = findViewById(R.id.textView);
        txtMail = findViewById(R.id.txtMail);
        imgChampion = findViewById(R.id.imgChampion);
        imgChampion.setImageResource(R.drawable.lol_leona_splash_hd);

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


    private String calculResulat() {

        String resQ1 = getIntent().getStringExtra("Q1");//ce définire
        String[] partsQ1 = resQ1.split("-");
        for (String uneValeur : partsQ1) {
            asignePoint(uneValeur);
        }

        String resQ2 = getIntent().getStringExtra("Q2");//Comment vivre
        String[] partsQ2 = resQ2.split("-");
        for (String uneValeur : partsQ2) {
            asignePoint(uneValeur);
        }

        String resQ3 = getIntent().getStringExtra("Q3");// Quelle région
        String[] partsQ3 = resQ3.split("-");
        for (String uneValeur : partsQ3) {
            asignePoint(uneValeur);
        }

        String resQ4 = getIntent().getStringExtra("Q4");//lors d'un comabt (multi Choice)
        String[] partsQ4 = resQ4.split("-");
        for (String uneValeur : partsQ4) {
            asignePoint(uneValeur);
        }

        String resQ5 = getIntent().getStringExtra("Q5");//arme
        String[] partsQ5 = resQ5.split("-");
        for (String uneValeur : partsQ5) {
            asignePoint(uneValeur);
        }

        String resQ6 = getIntent().getStringExtra("Q6");//comboBox

        HashMap<String, Integer> allPoste = new HashMap<String, Integer>();
        allPoste.put("top", top);
        allPoste.put("jungle", jungle);
        allPoste.put("mid", mid);
        allPoste.put("adc", adc);
        allPoste.put("supp", supp);

        Map.Entry<String, Integer> maxEntryPost = null;
        for (Map.Entry<String, Integer> entry : allPoste.entrySet()) {
            if (maxEntryPost == null || entry.getValue().compareTo(maxEntryPost.getValue()) > 0) {
                maxEntryPost = entry;
            }
        }

        HashMap<String, Integer> allRegions = new HashMap<String, Integer>();
        allRegions.put("bundle", bundle);
        allRegions.put("bilgwater", bilgwater);
        allRegions.put("targon", targon);
        allRegions.put("ionia", ionia);
        allRegions.put("demacia", demacia);
        allRegions.put("noxus", noxus);
        allRegions.put("shurima", shurima);
        allRegions.put("freljord", freljord);
        allRegions.put("piltover", piltover);

        Map.Entry<String, Integer> maxEntryRegion = null;
        for (Map.Entry<String, Integer> entry : allRegions.entrySet()) {
            if (maxEntryRegion == null || entry.getValue().compareTo(maxEntryRegion.getValue()) > 0) {
                maxEntryRegion = entry;
            }
        }

        if (maxEntryRegion.getKey().equals("bundle")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.teemo);
                return "vous êtes teemo !";
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.tristana);
                return "vous êtes tristana jungle c'est pas commun ! !";
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.veigar);
                return "vous êtes veigar !";
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.tristana);
                return "vous êtes tris !";
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.lulu);
                return "vous êtes lulu !";
            }
        } else if (maxEntryRegion.getKey().equals("bilgwater")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.illaoo);
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.graves);
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.fizz);
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.missfortune);
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.pyke);
            }
        } else if (maxEntryRegion.getKey().equals("targon")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.penthon);
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.diana);
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.aurelion);
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.aphelios);
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.lol_leona_splash_hd);
            }
        } else if (maxEntryRegion.getKey().equals("ionia")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.irelia);
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.lee_sin);
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.ahri);
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.splash_art_rakan);
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.splash_art_rakan);
            }
        } else if (maxEntryRegion.getKey().equals("demacia")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.garen);
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.jarvan);
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.lux_splash_0);
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.lucian);
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.morgana);
            }
        } else if (maxEntryRegion.getKey().equals("noxus")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.spash_darius);
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.cassio);
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.katarina);
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.spash_draven);
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.swain);
            }
        } else if (maxEntryRegion.getKey().equals("shurima")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.nasus);
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.rammus);
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.spash_azir);
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.sivir);
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.xerath);
            }
        } else if (maxEntryRegion.getKey().equals("freljord")) {
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.volibear);
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.sejuani);
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.lissandra);
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.ashe);
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.braum);
            }
        } else   {//piltover
            if(maxEntryPost.getKey().equals("top")){
                imgChampion.setImageResource(R.drawable.camille);
            }else if(maxEntryPost.getKey().equals("jungle")){
                imgChampion.setImageResource(R.drawable.vi);
            }else if(maxEntryPost.getKey().equals("mid")){
                imgChampion.setImageResource(R.drawable.orianna);
            }else if(maxEntryPost.getKey().equals("adc")){
                imgChampion.setImageResource(R.drawable.jinx);
            }else if(maxEntryPost.getKey().equals("supp")){
                imgChampion.setImageResource(R.drawable.blitzcrank);
            }
         }

        return "gg";
        //return "top "+Integer.toString(top)+"\njugnle "+Integer.toString(jungle)+"\nmid "+Integer.toString(mid)+"\nadc "+Integer.toString(adc)+"\nsupp "+Integer.toString(supp)+"\nerror "+Integer.toString(error);
    }

    private void asignePoint(String val){
        if(val.equals("top")){
            top+=1;
        }else if(val.equals("jungle")){
            jungle+=1;
        }else if(val.equals("mid")){
            mid+=1;
        }else if(val.equals("adc")){
            adc+=1;
        }else if(val.equals("supp")){
            supp+=1;
        }else if(val.equals("bundle")){
            bundle+=1;
        }else if(val.equals("bilgwater")){
            bilgwater+=1;
        }else if(val.equals("targon")){
            targon+=1;
        }else if(val.equals("ionia")){
            ionia+=1;
        }else if(val.equals("demacia")){
            demacia+=1;
        }else if(val.equals("noxus")){
            noxus+=1;
        }else if(val.equals("shurima")){
            shurima+=1;
        }else if(val.equals("freljord")){
            freljord+=1;
        }else if(val.equals("piltover")) { //dernier cas possible
            piltover+=1;
        }else{
            error+=1;
        }

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
package com.example.fertilizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import com.example.fertilizer.websites.AmmoNitActivity;
import com.example.fertilizer.websites.CalNitActivity;
import com.example.fertilizer.websites.HumicActivity;
import com.example.fertilizer.websites.PotassiumActivity;
import com.example.fertilizer.websites.UreaActivity;

public class FertiInfo extends AppCompatActivity {
    private CardView urea_ferti, potassi, cal_nit, ammo_nit, humic;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        getSupportActionBar().setTitle("Fertilizers");

        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString("islogin","false").equals("false")){
            openLogin();
        }

        urea_ferti=findViewById(R.id.urea_ferti);
        potassi=findViewById(R.id.potassi);
        cal_nit=findViewById(R.id.cal_nit);
        ammo_nit=findViewById(R.id.ammo_nit);
        humic=findViewById(R.id.humic);


        urea_ferti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FertiInfo.this, UreaActivity.class);
                startActivity(intent);
            }
        });

        potassi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FertiInfo.this, PotassiumActivity.class);
                startActivity(intent);
            }
        });

        cal_nit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FertiInfo.this, CalNitActivity.class);
                startActivity(intent);
            }
        });

        ammo_nit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FertiInfo.this, AmmoNitActivity.class);
                startActivity(intent);
            }
        });

        humic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FertiInfo.this, HumicActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                editor.putString("islogin","false");
                editor.commit();
                openLogin();
                break;
        }
        return true;
    }

    private void openLogin() {
        startActivity(new Intent(FertiInfo.this, MainActivity.class));
        finish();
    }
}
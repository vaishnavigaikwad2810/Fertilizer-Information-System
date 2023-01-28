package com.example.fertilizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userEmail, userPassword;
    private TextView tvShow;
    private RelativeLayout loginBtn;

    private String email, pass;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString("islogin","false").equals("yes")){
            openDash();
        }

        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);
        tvShow = findViewById(R.id.txt_show);
        loginBtn = findViewById(R.id.login_btn);

        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userPassword.getInputType() == 144){
                    userPassword.setInputType(129);
                    tvShow.setText("Hide");
                }else {
                    userPassword.setInputType(144);
                    tvShow.setText("Show");
                }
                userPassword.setSelection(userPassword.getText().length());
            }

        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });

    }

    private void validateData() {
        email = userEmail.getText().toString();
        pass = userPassword.getText().toString();

        if (email.isEmpty()){
            userEmail.setError("Required");
            userEmail.requestFocus();
        }else if (pass.isEmpty()){
            userPassword.setError("Required");
            userPassword.requestFocus();
        }else if (email.equals("farm@gmail.com") && pass.equals("12345")){
            editor.putString("islogin","yes");
            editor.commit();
            openDash();
        }else {
            Toast.makeText(this, "Please check email and password again!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void openDash() {
        startActivity(new Intent(MainActivity.this, FertiInfo.class));
        finish();
    }
}
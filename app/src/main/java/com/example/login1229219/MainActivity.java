package com.example.login1229219;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_username, et_password;
    Button b_login, b_register;
    TextView tv_loggedIn;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getINSTANCE(this);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        b_login = findViewById(R.id.b_login);
        b_register = findViewById(R.id.b_register);
        tv_loggedIn = findViewById(R.id.tv_loggedIn);



        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goRegister();
            }
        });

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
//                Dbhelper dbhelper = new Dbhelper(getApplicationContext());
//                db.usersDAO().getUser(username, password)

                if (db.usersDAO().getUser(username, password).size() > 0) {
                    tv_loggedIn.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    public void goRegister() {
        Intent i = new Intent(getApplicationContext(), Register.class);
        startActivity(i);
    }
}
package com.example.login1229219;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Register extends AppCompatActivity{
    Button b_register;
    EditText et_password2, et_password, et_username, et_email;
    TextView tv_passError;
    AppDatabase db;

    Dbhelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = AppDatabase.getINSTANCE(this);

        b_register = findViewById(R.id.b_register);
        et_password = findViewById(R.id.et_password);
        et_password2 = findViewById(R.id.et_password2);
        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        tv_passError = findViewById(R.id.tv_passsError);

        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_email.getText().toString();
                if (et_password.getText().toString().equals(et_password2.getText().toString())) {
                    if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        createUser();
                        goToMain();
                } else {
                        //email
                        tv_passError.setText("You must enter a valid email!");
                        tv_passError.setVisibility(View.VISIBLE);
                    }
                } else {
                    //password
                    tv_passError.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    public void goToMain() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void createUser() {
        UsersModel usersModel = new UsersModel(-1, et_username.getText().toString() ,et_password.getText().toString(),et_email.getText().toString());
        db.usersDAO().addUser(usersModel);


    }


}
package com.mosad.Happy_Day.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mosad.Happy_Day.R;

public class Login_Admin_Activity extends AppCompatActivity {

    EditText name, pass;
    Button Login;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__admin_);
        progressDialog = new ProgressDialog(this);

        name = (EditText) findViewById(R.id.adminname);
        pass = (EditText) findViewById(R.id.adminpass);
        Login = (Button) findViewById(R.id.Login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String username = name.getText().toString().trim();
                final String password = pass.getText().toString().trim();
                if (username.equals("admin") || password.equals("12345")) {

                    startActivity(new Intent(Login_Admin_Activity.this, Books.class));


                } else {

                    Toast.makeText(Login_Admin_Activity.this, "wrong Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}

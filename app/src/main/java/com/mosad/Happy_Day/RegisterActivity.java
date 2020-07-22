package com.mosad.Happy_Day;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUsername, editTextEmail, editTextPassword;
    Button btn_register;
    TextView textView;
    public static final String Name = "name";
    public static final String Email = "email";
    public static final String Password = "password";

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextUsername = findViewById(R.id.txtuser);
        editTextEmail = findViewById(R.id.txtemail);
        editTextPassword = findViewById(R.id.txtpass);
        btn_register = findViewById(R.id.btnregister);
        btn_register = (Button) findViewById(R.id.btnregister);
        btn_register.setOnClickListener(this);
        inittextViewLogin();
    }

    public void onClick(View view) {

        if (view.getId() == R.id.btnregister) {

            final String username = editTextUsername.getText().toString().trim();
            final String email = editTextEmail.getText().toString().trim();
            final String password = editTextPassword.getText().toString().trim();


            if (username.equals("") || password.equals("") || email.equals("")) {

                Toast.makeText(this, "من فضلك أدخل البيانات", Toast.LENGTH_SHORT).show();
            } else {
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://apphappy.000webhostapp.com/Register.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this, "ERROR" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> jsonObject = new HashMap<String, String>();
                        jsonObject.put("username", username);
                        jsonObject.put("password", password);
                        jsonObject.put("email", email);
                        return jsonObject;

                    }

                };

                stringRequest.setRetryPolicy(new RetryPolicy() {
                    @Override
                    public int getCurrentTimeout() {
                        return 5000;
                    }

                    @Override
                    public int getCurrentRetryCount() {
                        return 5000;
                    }

                    @Override
                    public void retry(VolleyError error) throws VolleyError {

                    }
                });
                requestQueue.add(stringRequest);

            }


        }
    }


    public void inittextViewLogin() {
        textView = (TextView) findViewById(R.id.textViewLogin);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    public void backlogin(View view) {

        Intent intent = new Intent(RegisterActivity.this, SplashScreenActivity.class);
        startActivity(intent);

    }
}

package com.mosad.Happy_Day;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mosad.Happy_Day.Fragments.ProfileFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtemail, edtpassword;
    ImageView backButton;
    Button btnlogin;
    TextView txtsignup;

    public static final String KEY_EMAIL = "emial";
    public static final String KEY_PASSWORD = "password";

    ProgressDialog progressDialog;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        edtemail = findViewById(R.id.email);
        edtpassword = findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(this);

        initBackButton();
        inittxtsignup();
    }

    public void onClick(View view) {

        if (view.getId() == R.id.btnlogin) {
            progressDialog.setTitle("جارى تسجيل الدخول");

            progressDialog.show();


            final String Email = edtemail.getText().toString().trim();
            final String Password = edtpassword.getText().toString().trim();


            if (Email.equals("") || Password.equals("")) {

                Toast.makeText(this, "Enter Vaild username & password", Toast.LENGTH_SHORT).show();

            } else {
                //hena dyt al data aly hnb3tha lel al server
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("email", edtemail.getText().toString());
                    jsonObject.put("password", edtpassword.getText().toString());
                } catch (Exception e) {
                    e.getStackTrace();
                }

                RequestQueue requestQueue = Volley.newRequestQueue(this);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://apphappy.000webhostapp.com/loginpage.php", jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            progressDialog.dismiss();
                            System.out.println("Data" + jsonObject.toString());
                            boolean responsestatus = jsonObject.getBoolean("Success");
                            if (responsestatus) {
                                String name = jsonObject.getJSONObject("data").getString("username");
                                String email = jsonObject.getJSONObject("data").getString("email");



                                SharedPreferences sharedPreferences = getSharedPreferences("userFile", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("username", name);
                                editor.putString("email", email);

                                editor.apply();

                                Toast.makeText(LoginActivity.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                    }
                });


                requestQueue.add(jsonObjectRequest);

            }

        }
    }

    public void initBackButton() {

        backButton = findViewById(R.id.backlogin);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SplashScreenActivity.class);
                startActivity(intent);
            }
        });

    }

    public void inittxtsignup() {

        txtsignup = findViewById(R.id.txtsignup);
        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


}




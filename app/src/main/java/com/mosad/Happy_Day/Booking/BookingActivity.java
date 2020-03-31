package com.mosad.Happy_Day.Booking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mosad.Happy_Day.R;
import com.mosad.Happy_Day.RegisterActivity;

import java.util.HashMap;
import java.util.Map;

public class BookingActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, phoneNo, datee;
    TextView hallname,ok;
    Button btn_book;


    public static final String name = "Name";
    public static final String hall = "HallName";
    public static final String phone = "phoneNumber";
    public static final String msg = "Message";


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        requestPermissions(new String[]{Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
        TextView Display = findViewById(R.id.display_joy);
        Bundle bn = getIntent().getExtras();
        String name = bn.getString("abc");
        Display.setText(String.valueOf(name));
        username = findViewById(R.id.username);
        hallname = findViewById(R.id.display_joy);
        phoneNo = findViewById(R.id.phoneNo);
        datee = findViewById(R.id.date);
        ok = findViewById(R.id.ok);
        btn_book = findViewById(R.id.btn_book);
        btn_book = (Button) findViewById(R.id.btn_book);
        btn_book.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.btn_book) {

            final String Name = username.getText().toString().trim();
            final String Hall = hallname.getText().toString().trim();
            final String Phonee = phoneNo.getText().toString().trim();
            final String date = datee.getText().toString().trim();
            final String ook = ok.getText().toString().trim();
            if (Name.equals("") || Hall.equals("") || Phonee.equals("")) {

                Toast.makeText(this, "من فضلك أدخل البيانات", Toast.LENGTH_SHORT).show();


            } else {
                // SMS ly user

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phone,null,ook,null,null);

                // hena bnb3t el data ly server
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://hallsapplication.000webhostapp.com/Booking.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(BookingActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(BookingActivity.this, "ERROR" + error.toString(), Toast.LENGTH_LONG).show();
                    }

                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> jsonObject = new HashMap<String, String>();
                        jsonObject.put("Name", Name);
                        jsonObject.put("HallName", Hall);
                        jsonObject.put("PhoneNumber", Phonee);
                        jsonObject.put("booking_date", date);

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
}


package com.mosad.Happy_Day.Hall_Details.Wedding_detials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mosad.Happy_Day.Booking.BookingActivity;
import com.mosad.Happy_Day.R;

public class Laylaty_detials extends AppCompatActivity {
    RatingBar ratingBar;

    ImageView location;

    private String[] imageUrls = new String[]{

            "https://hallsapplication.000webhostapp.com/images/l4.jpg",

            "https://hallsapplication.000webhostapp.com/images/l5.jpg",

            "https://hallsapplication.000webhostapp.com/images/l6.jpg",

            "https://hallsapplication.000webhostapp.com/images/l4.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laylaty_detials);
    }

    public void btn_lyhty(View view) {
        final TextView Output = (TextView) findViewById(R.id.txt_laylaty);
        String Data = Output.getText().toString();
        Intent intent =new Intent(Laylaty_detials.this, BookingActivity.class);
        intent.putExtra("abc",Data);
        startActivity(intent);
    }

    public void call(View view) {
        final TextView callphone = (TextView) findViewById(R.id.phone);
        ImageView call = (ImageView) findViewById(R.id.telphone);
        final Intent icall = new Intent(Intent.ACTION_DIAL);
        icall.setData(Uri.parse("tel:" + callphone.getText()));
        startActivity(icall);
    }
}

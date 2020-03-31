package com.mosad.Happy_Day.Hall_Details.Wedding_detials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mosad.Happy_Day.Booking.BookingActivity;
import com.mosad.Happy_Day.R;

public class MyJoy_details extends AppCompatActivity {

    RatingBar ratingBar;

    private String[] imageUrls = new String[]{

            "https://hallsapplication.000webhostapp.com/images/frhty1.jpg",
            "https://hallsapplication.000webhostapp.com/images/frhty2.jpg",
            "https://hallsapplication.000webhostapp.com/images/frhty3.jpg",
            "https://hallsapplication.000webhostapp.com/images/frhty4.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_joy_details);
        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(MyJoy_details.this, "Value is " + v, Toast.LENGTH_LONG).show();
            }
        });

    }

    public void btn_frhty(View view) {
        final  TextView Output = (TextView) findViewById(R.id.txt_name);
        String Data = Output.getText().toString();
        Intent intent =new Intent(MyJoy_details.this, BookingActivity.class);
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


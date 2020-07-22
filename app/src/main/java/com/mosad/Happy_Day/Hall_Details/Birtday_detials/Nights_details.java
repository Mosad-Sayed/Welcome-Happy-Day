package com.mosad.Happy_Day.Hall_Details.Birtday_detials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mosad.Happy_Day.Booking.BookingActivity;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.ViewPagerAdapter;
import com.mosad.Happy_Day.R;

public class Nights_details extends AppCompatActivity {

    RatingBar ratingBar;
    Button btn_book;


    private String[] imageUrls = new String[]{

            "https://apphappy.000webhostapp.com/images/night.jpg",

            "https://apphappy.000webhostapp.com/images/night1.jpg",

            "https://apphappy.000webhostapp.com/images/night2.jpg",

            "https://apphappy.000webhostapp.com/images/night3.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nights_details);
        btn_book = (Button) findViewById(R.id.night) ;

        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(Nights_details.this, "Value is " +v, Toast.LENGTH_LONG).show();
            }
        });
    }


    public void book(View view) {
        final TextView Output = (TextView) findViewById(R.id.txt_night);
        String Data = Output.getText().toString();
        Intent intent =new Intent(Nights_details.this, BookingActivity.class);
        intent.putExtra("abc",Data);
        startActivity(intent);

    }
}

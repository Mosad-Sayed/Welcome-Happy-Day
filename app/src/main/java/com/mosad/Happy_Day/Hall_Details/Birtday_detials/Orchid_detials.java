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

public class Orchid_detials extends AppCompatActivity {
    RatingBar ratingBar;
    Button btn_book;


    private String[] imageUrls = new String[]{

            "https://hallsapplication.000webhostapp.com/images/mrwa1.jpg",

            "https://hallsapplication.000webhostapp.com/images/mrwa2.jpg",

            "https://hallsapplication.000webhostapp.com/images/mrwa3.jpg",

            "https://hallsapplication.000webhostapp.com/images/marwa4.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orchid_detials);
        btn_book = (Button) findViewById(R.id.panroma) ;

        ViewPager viewPager = findViewById(R.id.view_pager);
        com.mosad.Happy_Day.Hall_Details.Wedding_detials.ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(Orchid_detials.this, "Value is " +v, Toast.LENGTH_LONG).show();
            }
        });
    }


    public void book(View view) {
        final TextView Output = (TextView) findViewById(R.id.txt_panroma);
        String Data = Output.getText().toString();
        Intent intent =new Intent(Orchid_detials.this, BookingActivity.class);
        intent.putExtra("abc",Data);
        startActivity(intent);

    }
}


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

public class Sonsta_detials extends AppCompatActivity {
    RatingBar ratingBar;

    ImageView location;

    private String[] imageUrls = new String[]{

            "https://hallsapplication.000webhostapp.com/images/s.jpg",

            "https://hallsapplication.000webhostapp.com/images/s1.jpg",

            "https://hallsapplication.000webhostapp.com/images/s2.jpg",

            "https://hallsapplication.000webhostapp.com/images/s3.jpg"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonsta_detials);

        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);
        location = (ImageView) findViewById(R.id.location);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(Sonsta_detials.this, "Value is " + v, Toast.LENGTH_LONG).show();
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent google_Map = new Intent(Intent.ACTION_VIEW);
                google_Map.setData(Uri.parse("geo:30.411229, 31.572703?z=15"));
                startActivity(google_Map);
            }
        });

    }

    public void btn_sonsta(View view) {
        final TextView Output = (TextView) findViewById(R.id.txt_name1);
        String Data = Output.getText().toString();
        Intent intent =new Intent(Sonsta_detials.this, BookingActivity.class);
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


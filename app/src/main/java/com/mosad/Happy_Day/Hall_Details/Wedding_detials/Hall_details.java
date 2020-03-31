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

public class Hall_details extends AppCompatActivity {

    RatingBar ratingBar;
    ImageView location;

    private String[] imageUrls = new String[]{

            "https://hallsapplication.000webhostapp.com/images/a.jpg",

            "https://hallsapplication.000webhostapp.com/images/b.jpg",

            "https://hallsapplication.000webhostapp.com/images/c.jpg",

            "https://hallsapplication.000webhostapp.com/images/d.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_details);
        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);
        location = (ImageView) findViewById(R.id.location);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(Hall_details.this, "Value is " +v, Toast.LENGTH_LONG).show();
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent google_Map = new Intent(Intent.ACTION_VIEW);
                google_Map.setData(Uri.parse("geo:30.408741, 31.562304?z=15"));
                startActivity(google_Map);
            }
        });



    }

    public void btn_grand(View view) {

        final TextView Output = (TextView) findViewById(R.id.txt_grand);
        String Data = Output.getText().toString();
        Intent intent =new Intent(Hall_details.this, BookingActivity.class);
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

package com.mosad.Happy_Day.Hall_Details.Engagement_occasions_detials;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.mosad.Happy_Day.Booking.BookingActivity;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.ViewPagerAdapter;
import com.mosad.Happy_Day.R;

public class SweetNight_details extends AppCompatActivity {

    RatingBar ratingBar;
    ImageView location;


    private String[] imageUrls = new String[]{

            "https://tourismapplication.000webhostapp.com/images/n1.jpg",

            "https://tourismapplication.000webhostapp.com/images/n2.jpg",

            "https://tourismapplication.000webhostapp.com/images/n3.jpg",

            "https://tourismapplication.000webhostapp.com/images/n4.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_night_details);
        location = (ImageView) findViewById(R.id.location);

        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(SweetNight_details.this, "Value is " + v, Toast.LENGTH_LONG).show();
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent google_Map = new Intent(Intent.ACTION_VIEW);
                google_Map.setData(Uri.parse("geo:30.415862, 31.562108?z=15"));
                startActivity(google_Map);
            }
        });

    }

    public void btn_swwet(View view) {
        final TextView Output = (TextView) findViewById(R.id.txt_A7la);
        String Data = Output.getText().toString();
        Intent intent =new Intent(SweetNight_details.this, BookingActivity.class);
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

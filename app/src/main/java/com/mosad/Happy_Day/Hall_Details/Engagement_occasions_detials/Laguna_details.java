package com.mosad.Happy_Day.Hall_Details.Engagement_occasions_detials;

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
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.ViewPagerAdapter;
import com.mosad.Happy_Day.R;

public class Laguna_details extends AppCompatActivity {
    RatingBar ratingBar;

    ImageView location;

    private String[] imageUrls = new String[]{

            "https://hallsapplication.000webhostapp.com/images/meet11.jpg",

            "https://hallsapplication.000webhostapp.com/images/meet12.jpg",

            "https://hallsapplication.000webhostapp.com/images/meet13.jpg",

            "https://hallsapplication.000webhostapp.com/images/meet14.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laguna_details);


        ViewPager viewPager = findViewById(R.id.view_pager);
        com.mosad.Happy_Day.Hall_Details.Engagement_occasions_detials.ViewPagerAdapter adapter = new com.mosad.Happy_Day.Hall_Details.Engagement_occasions_detials.ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);
        location = (ImageView) findViewById(R.id.location);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(Laguna_details.this, "Value is " + v, Toast.LENGTH_LONG).show();
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


    public void btn_lguna(View view) {
        final TextView Output = (TextView) findViewById(R.id.txt_lguna);
        String Data = Output.getText().toString();
        Intent intent = new Intent(Laguna_details.this, BookingActivity.class);
        intent.putExtra("abc", Data);
        startActivity(intent);
    }

}
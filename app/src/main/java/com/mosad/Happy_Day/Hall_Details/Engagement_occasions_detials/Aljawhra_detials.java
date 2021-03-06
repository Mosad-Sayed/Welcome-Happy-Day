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

public class Aljawhra_detials extends AppCompatActivity {
    RatingBar ratingBar;
    ImageView location;

    private String[] imageUrls = new String[]{

            "https://apphappy.000webhostapp.com/images/l8.jpg",

            "https://apphappy.000webhostapp.com/images/l9.jpg",

            "https://apphappy.000webhostapp.com/images/l8.jpg",

            "https://apphappy.000webhostapp.com/images/l9.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aljawhra_detials);
        ViewPager viewPager = findViewById(R.id.view_pager);
        com.mosad.Happy_Day.Hall_Details.Wedding_detials.ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);
        location = (ImageView) findViewById(R.id.location);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(Aljawhra_detials.this, "Value is " + v, Toast.LENGTH_LONG).show();
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
    public void btn_jwhra(View view) {

        final TextView Output = (TextView) findViewById(R.id.txt_jwhra);
        String Data = Output.getText().toString();
        Intent intent = new Intent(Aljawhra_detials.this, BookingActivity.class);
        intent.putExtra("abc", Data);
        startActivity(intent);
    }
}

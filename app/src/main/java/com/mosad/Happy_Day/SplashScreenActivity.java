package com.mosad.Happy_Day;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashScreenActivity extends Activity {

    ImageView imageviewsplash;
    TextView txtappname;
    LinearLayout linearLayout;
    Thread SplashThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageviewsplash = findViewById(R.id.imageviewsplash);
        txtappname = findViewById(R.id.txtappname);
      linearLayout = findViewById(R.id.relative);

        // startAnimations();

        // }

   /* public void startAnimations() {

        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.roate);
        Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate);

        rotate.reset();
        translate.reset();
        linearLayout.clearAnimation();

        imageviewsplash.startAnimation(rotate);
        txtappname.startAnimation(translate);

        SplashThread = new Thread() {

            @Override
            public void run() {
                super.run();
                int waited = 0;
                while (waited < 3000) {
                    try {
                        sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    waited += 100;
                }


            }
        };
        SplashThread.start();


    }*/
    }

    public void btn_log(View view) {

        Intent intent = new Intent(SplashScreenActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    public void btn_regiser(View view) {

        Intent intent = new Intent(SplashScreenActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}

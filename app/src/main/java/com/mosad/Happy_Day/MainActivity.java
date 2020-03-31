package com.mosad.Happy_Day;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.view.GravityCompat;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.mosad.Happy_Day.Activity.Login_Admin_Activity;
import com.mosad.Happy_Day.Fragments.AboutFragment;
import com.mosad.Happy_Day.Fragments.HomeFragment;
import com.mosad.Happy_Day.Fragments.ProfileFragment;
import com.mosad.Happy_Day.Fragments.TeamworkFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        TextView nameTextView = navigationView.getHeaderView(0).findViewById(R.id.tv_main_name);
        TextView emailTextView = navigationView.getHeaderView(0).findViewById(R.id.tv_main_email);

        SharedPreferences sharedPreferences = getSharedPreferences("userFile", MODE_PRIVATE);
        nameTextView.setText(sharedPreferences.getString("username", ""));
        emailTextView.setText(sharedPreferences.getString("email", ""));

        navigationView.setNavigationItemSelectedListener(this);
        MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, HomeFragment.newInstance()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("ResourceType")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, HomeFragment.newInstance()).commit();
        } else if (id == R.id.nav_profile) {
            MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, ProfileFragment.newInstance()).commit();


        } else if (id == R.id.nav_Fav) {

        } else if (id == R.id.nav_books) {

            Intent intent = new Intent(this, Login_Admin_Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_about) {
            MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, AboutFragment.newInstance()).commit();


        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent();
            sharingIntent.setAction(Intent.ACTION_SEND);
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "\"https://play.google.com/store/apps/details?id=\" + this.Context.com.mosad.halls");
            sharingIntent.setType("text/plain");
            startActivity(Intent.createChooser(sharingIntent, "Share Via"));

        } else if (id == R.id.nav_log) {

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        }  else if (id == R.id.Team_Work) {

            MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, TeamworkFragment.newInstance()).commit();


        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private HomeFragment getChildFragmentManager() {

        return new HomeFragment();
    }


}

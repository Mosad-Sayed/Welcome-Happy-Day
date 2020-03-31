package com.mosad.Happy_Day.Fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.mosad.Happy_Day.Activity.BirhdayActivity;
import com.mosad.Happy_Day.Activity.Engagement_occasionsActivity;
import com.mosad.Happy_Day.MainActivity;
import com.mosad.Happy_Day.R;
import com.mosad.Happy_Day.Activity.WeddingActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button btn_control, btn_help, btn_share;
    Boolean open = true;


    public static HomeFragment newInstance() {

        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        final Button button = (Button) view.findViewById(R.id.btn_wedding);
        final Button birhday = (Button) view.findViewById(R.id.btn_birthday);
        final Button engagement = (Button) view.findViewById(R.id.btn_engagement);
        final ImageView opennav = (ImageView) view.findViewById(R.id.opennav);


        ImageView manu = (ImageView) view.findViewById(R.id.manu);


        btn_control = (Button) view.findViewById(R.id.btn_control);
        btn_help = (Button) view.findViewById(R.id.btn_help);
        btn_share = (Button) view.findViewById(R.id.btn_share);

        HomeFragment homeFragment = this;
        final Animation train_in = AnimationUtils.loadAnimation(homeFragment.getContext(), R.anim.train_in);
        final Animation train_out = AnimationUtils.loadAnimation(homeFragment.getContext(), R.anim.train_out);
        final Animation rotae = AnimationUtils.loadAnimation(homeFragment.getContext(), R.anim.rotae);


        btn_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (open) {
                    open = false;
                    btn_control.setAnimation(train_in);
                    btn_help.setAnimation(train_in);
                    btn_share.setAnimation(train_in);

                    btn_help.setVisibility(View.VISIBLE);
                    btn_share.setVisibility(View.VISIBLE);

                } else {

                    open = true;
                    btn_control.setAnimation(train_out);
                    btn_help.setAnimation(train_out);
                    btn_share.setAnimation(train_out);

                    btn_help.setVisibility(View.INVISIBLE);
                    btn_share.setVisibility(View.INVISIBLE);

                }
            }
        });
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream inputStream = null;


                try {

                    inputStream = getActivity().getAssets().open("help.txt");

                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader BR = new BufferedReader(inputStreamReader);
                    String line;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = BR.readLine()) != null) {

                        stringBuilder.append(line + "\n");

                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Help");
                    builder.setIcon(R.drawable.ic_warning_black_24dp);
                    builder.setMessage(Html.fromHtml(stringBuilder + ""));
                    builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent();
                sharingIntent.setAction(Intent.ACTION_SEND);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "\"https://play.google.com/store/apps/details?id=\" + this.Context.com.mosad.halls");
                sharingIntent.setType("text/plain");
                startActivity(Intent.createChooser(sharingIntent, "Share Via"));


            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), WeddingActivity.class);

                startActivity(intent);


            }

        });

        birhday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), BirhdayActivity.class);

                startActivity(intent);

            }
        });

        engagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Engagement_occasionsActivity.class);

                startActivity(intent);

            }
        });

        return view;
    }


}

package com.mosad.Happy_Day.Fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mosad.Happy_Day.LoginActivity;
import com.mosad.Happy_Day.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
Button logout;


    public ProfileFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        ProfileFragment profileFragment = new ProfileFragment();
        return profileFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        TextView nameTextView = view.findViewById(R.id.txtname);
        TextView emailTextView = view.findViewById(R.id.txtmail);
        logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });



        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("userFile",MODE_PRIVATE);
        nameTextView.setText(sharedPreferences.getString("username",""));
        emailTextView.setText(sharedPreferences.getString("email",""));

        return view;
    }




}

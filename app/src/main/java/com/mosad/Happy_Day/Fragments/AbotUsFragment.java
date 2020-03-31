package com.mosad.Happy_Day.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mosad.Happy_Day.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AbotUsFragment extends Fragment {


    public AbotUsFragment() {
        // Required empty public constructor
    }
    public static AbotUsFragment newInstance() {

        AbotUsFragment atFragment=new AbotUsFragment();
        return atFragment;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_abot_us, container, false);
    }

}

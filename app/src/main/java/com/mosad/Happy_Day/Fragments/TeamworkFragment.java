package com.mosad.Happy_Day.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mosad.Happy_Day.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeamworkFragment extends Fragment {
    private RecyclerView rv;
    ArrayList<TeamItem> Data;
    String url = "https://hallsapplication.000webhostapp.com/images/a.jpg";


    public TeamworkFragment() {
        // Required empty public constructor
    }

    public static TeamworkFragment newInstance() {

        TeamworkFragment teamworkFragment = new TeamworkFragment();
        return teamworkFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_teamwork, container, false);
        Data = new ArrayList<>();
        TeamItem firstitem = new TeamItem();
        firstitem.name = "الدكتور المشرف \n أ.د أحمد سعيد";
        firstitem.image = R.drawable.drahmed;
        Data.add(firstitem);
        TeamItem second = new TeamItem();
        second.name = "عضو الهيئة \n م. أحمد رياض";
        second.image = R.drawable.eng;
        Data.add(second);
        TeamItem third = new TeamItem();
        third.name = "مسعد السيد";
        third.image = R.drawable.mosad;
        Data.add(third);
        TeamItem four = new TeamItem();
        four.name = "محمد سعيد";
        four.image = R.drawable.mohamed;
        Data.add(four);
        TeamItem five = new TeamItem();
        five.name = "محمد علـى";
        five.image = R.drawable.ali;
        Data.add(five);
        TeamItem six = new TeamItem();
        six.name = "محمد النعمان";
        six.image = R.drawable.naman;
        Data.add(six);
        TeamItem seven = new TeamItem();
        seven.name = "محمد الشوادفى";
        seven.image = R.drawable.shawdfy;
        Data.add(seven);
        TeamItem eight = new TeamItem();
        eight.name = "كريم صالح";
        eight.image = R.drawable.karim;
        Data.add(eight);
        TeamItem nine = new TeamItem();
        nine.name = "محمـود خـالد";
        nine.image = R.drawable.mahmoud;
        Data.add(nine);
        TeamItem ten = new TeamItem();
        ten.name = "نـادر فـايـد";
        Data.add(ten);
        TeamItem elv = new TeamItem();
        elv.name = "رضـا محمـود";
        Data.add(elv);

        rv = (RecyclerView) rootView.findViewById(R.id.team_RV);
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rv.setAdapter(new TeamAdapter(getActivity(), Data));

        return rootView;
    }

}

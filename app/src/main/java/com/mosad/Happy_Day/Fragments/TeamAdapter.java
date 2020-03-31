package com.mosad.Happy_Day.Fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mosad.Happy_Day.R;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.UserHolder> {

    Context c;
    ArrayList<TeamItem>Data;

    public TeamAdapter(Context c, ArrayList<TeamItem> Space) {

        this.c = c;
        this.Data =Space;

    }

    @NonNull
    @Override
    public TeamAdapter.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(c).inflate(R.layout.team_work, parent, false);

        UserHolder userHolder = new UserHolder(v);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.UserHolder holder, int position) {
        holder.nameTxt.setText(Data.get(position).name);
        holder.imageView.setImageResource(Data.get(position).image);



    }


    @Override
    public int getItemCount() {
        return Data.size();
    }


    public class UserHolder extends RecyclerView.ViewHolder{

        TextView nameTxt;
        ImageView imageView;

        public UserHolder(@NonNull View itemView) {
            super(itemView);

            nameTxt = (TextView)itemView.findViewById(R.id.nameTXt);
            imageView = itemView.findViewById(R.id.imageView_team);

        }
    }
}


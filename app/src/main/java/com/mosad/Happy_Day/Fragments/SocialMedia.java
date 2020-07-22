package com.mosad.Happy_Day.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mosad.Happy_Day.R;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SocialMedia extends Fragment implements View.OnClickListener {
    public static final String Email = "email";
    public static final String Message = "message";
    EditText social_ed1, social_ed2;
    Button send;


    public SocialMedia() {
        // Required empty public constructor
    }

    public static SocialMedia newInstance() {

        SocialMedia socialMedia = new SocialMedia();
        return socialMedia;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_social_media, container, false);
        social_ed1 = view.findViewById(R.id.social_ed1);
        social_ed2 = view.findViewById(R.id.social_ed2);
        send = view.findViewById(R.id.send);
        send = (Button) view.findViewById(R.id.send);
        send.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.send) {

            final String email = social_ed1.getText().toString().trim();
            final String message = social_ed2.getText().toString().trim();

            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://apphappy.000webhostapp.com/suggation.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(), "ERROR" + error.toString(), Toast.LENGTH_LONG).show();
                }
            }) {

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> jsonObject = new HashMap<String, String>();
                    jsonObject.put("email", email);
                    jsonObject.put("message", message);
                    return jsonObject;

                }

            };

            stringRequest.setRetryPolicy(new RetryPolicy() {
                @Override
                public int getCurrentTimeout() {
                    return 5000;
                }

                @Override
                public int getCurrentRetryCount() {
                    return 5000;
                }

                @Override
                public void retry(VolleyError error) throws VolleyError {

                }
            });
            requestQueue.add(stringRequest);

        }


    }
}




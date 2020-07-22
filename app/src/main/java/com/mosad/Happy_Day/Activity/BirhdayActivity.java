package com.mosad.Happy_Day.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mosad.Happy_Day.Hall_Details.Birtday_detials.Farida_details;
import com.mosad.Happy_Day.Hall_Details.Birtday_detials.Nights_details;
import com.mosad.Happy_Day.Hall_Details.Birtday_detials.Orchid_detials;
import com.mosad.Happy_Day.Hall_Details.Birtday_detials.Panorama_details;
import com.mosad.Happy_Day.Hall_Details.Birtday_detials.Riviera_detials;
import com.mosad.Happy_Day.MainActivity;
import com.mosad.Happy_Day.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BirhdayActivity extends AppCompatActivity {

    String url = "https://apphappy.000webhostapp.com/birhday.php";
    TextView textView;
    RequestQueue requestQueue;
    ListView listView;

    ArrayList<BirhdayItem> birhdayItems = new ArrayList<BirhdayItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birhday);


        textView = (TextView) findViewById(R.id.textview);
        requestQueue = Volley.newRequestQueue(this);
        listView = (ListView) findViewById(R.id.listview);

        JSONObject jsonObject = new JSONObject();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://apphappy.000webhostapp.com/birhday.php", jsonObject, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                JSONArray jsonArray = null;
                try {
                    jsonArray = response.getJSONArray("allhalls");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject respons = jsonArray.getJSONObject(i);
                        String id = respons.getString("id");
                        String name = respons.getString("name");
                        String price = respons.getString("price");
                        String img = respons.getString("imgUrl");

                        birhdayItems.add(new BirhdayItem(id, name, price, img));
                        listAllItem();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLY", "ERROR");
            }
        });

        requestQueue.add(jsonObjectRequest);

    }

    public void listAllItem() {

        listAdapter lA = new listAdapter(birhdayItems);
        listView.setAdapter(lA);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){

                    Intent intent = new Intent(BirhdayActivity.this, Nights_details.class);
                    startActivity(intent);
                }
                if (i==1){

                    Intent intent = new Intent(BirhdayActivity.this, Panorama_details.class);
                    startActivity(intent);
                }
                if (i==2){

                    Intent intent = new Intent(BirhdayActivity.this, Riviera_detials.class);
                    startActivity(intent);
                }
                if (i==3){

                    Intent intent = new Intent(BirhdayActivity.this, Orchid_detials.class);
                    startActivity(intent);
                }
                if (i==4){

                    Intent intent = new Intent(BirhdayActivity.this, Farida_details.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void main(View view) {
        Intent intent = new Intent(BirhdayActivity.this, MainActivity.class);
        startActivity(intent);
    }

    class listAdapter extends BaseAdapter {

        ArrayList<BirhdayItem> listA = new ArrayList<BirhdayItem>();

        public listAdapter(ArrayList<BirhdayItem> listA) {
            this.listA = listA;
        }

        @Override
        public int getCount() {
            return listA.size();
        }

        @Override
        public Object getItem(int i) {
            return listA.get(i).id;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View view1 = layoutInflater.inflate(R.layout.row_itm, null);

            TextView id = (TextView) view1.findViewById(R.id.textView_id);
            TextView name = (TextView) view1.findViewById(R.id.textView_name);
            TextView price = (TextView) view1.findViewById(R.id.textView_price);
            ImageView img = (ImageView) view1.findViewById(R.id.imageView);


            id.setText(listA.get(i).id);
            name.setText(listA.get(i).name);
            price.setText(listA.get(i).price);


            Picasso.get().load("https://apphappy.000webhostapp.com/images/" + listA.get(i).img).into(img);


            return view1;
        }



    }

}
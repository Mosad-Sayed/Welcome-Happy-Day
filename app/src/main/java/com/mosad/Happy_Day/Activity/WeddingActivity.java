package com.mosad.Happy_Day.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.CairoFestival_detials;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.Festival_detials;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.Hall_details;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.LaVista_detials;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.Laylaty_detials;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.MyJoy_details;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.Sonsta_detials;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.SweetNight_details;
import com.mosad.Happy_Day.MainActivity;
import com.mosad.Happy_Day.R;
import com.squareup.picasso.Picasso;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class WeddingActivity extends AppCompatActivity {
    String url = "https://hallsapplication.000webhostapp.com/wedding.php";
    TextView textView;
    RequestQueue requestQueue;
    ListView listView;
    Button help;
    ImageView white_back;
    ArrayList<WeddingItem> listItems = new ArrayList<WeddingItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding);
        initback();
        textView = (TextView) findViewById(R.id.textview);
        requestQueue = Volley.newRequestQueue(this);
        listView = (ListView) findViewById(R.id.listview);

        // get Data in database
        JSONObject jsonObject = new JSONObject();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://hallsapplication.000webhostapp.com/wedding.php", jsonObject, new Response.Listener<JSONObject>() {

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

                        listItems.add(new WeddingItem(id, name, price, img));
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

    // Open Activity Detials
    public void listAllItem() {

        listAdapter lA = new listAdapter(listItems);
        listView.setAdapter(lA);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {

                    Intent intent = new Intent(WeddingActivity.this, Hall_details.class);
                    startActivity(intent);
                }
                if (i == 1) {

                    Intent intent = new Intent(WeddingActivity.this, Sonsta_detials.class);
                    startActivity(intent);
                }
                if (i == 2) {

                    Intent intent = new Intent(WeddingActivity.this, Laylaty_detials.class);
                    startActivity(intent);
                }

                if (i == 3) {

                    Intent intent = new Intent(WeddingActivity.this, Festival_detials.class);
                    startActivity(intent);
                }
                if (i == 4) {

                    Intent intent = new Intent(WeddingActivity.this, SweetNight_details.class);
                    startActivity(intent);
                }
                if (i == 5) {

                    Intent intent = new Intent(WeddingActivity.this, CairoFestival_detials.class);
                    startActivity(intent);
                }
                if (i == 6) {

                    Intent intent = new Intent(WeddingActivity.this, LaVista_detials.class);
                    startActivity(intent);
                }
                if (i == 7) {

                    Intent intent = new Intent(WeddingActivity.this, MyJoy_details.class);
                    startActivity(intent);
                }

            }
        });

    }

    // Adpter
    class listAdapter extends BaseAdapter {

        ArrayList<WeddingItem> listA = new ArrayList<WeddingItem>();

        public listAdapter(ArrayList<WeddingItem> listA) {
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

            Picasso.get().load("https://hallsapplication.000webhostapp.com/images/" + listA.get(i).img).into(img);

            return view1;
        }
    }

    public void initback() {
        white_back = (ImageView) findViewById(R.id.white_back);
        white_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WeddingActivity.this, MainActivity.class));
            }
        });
    }

}

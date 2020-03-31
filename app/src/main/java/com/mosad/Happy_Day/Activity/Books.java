package com.mosad.Happy_Day.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mosad.Happy_Day.Fragments.HomeFragment;
import com.mosad.Happy_Day.Hall_Details.Wedding_detials.Hall_details;
import com.mosad.Happy_Day.MainActivity;
import com.mosad.Happy_Day.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Books extends AppCompatActivity {
    String url = "https://hallsapplication.000webhostapp.com/allBooks.php";
    TextView textView;
    RequestQueue requestQueue;
    ListView listView;

    ArrayList<BooksItem> listItems = new ArrayList<BooksItem>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1231);
        textView = (TextView) findViewById(R.id.textview);
        requestQueue = Volley.newRequestQueue(this);
        listView = (ListView) findViewById(R.id.listview);
        JSONObject jsonObject = new JSONObject();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://hallsapplication.000webhostapp.com/allBooks.php", jsonObject, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                JSONArray jsonArray = null;
                try {
                    jsonArray = response.getJSONArray("allBooks");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject respons = jsonArray.getJSONObject(i);
                        String id = respons.getString("id");
                        String name = respons.getString("Name");
                        String hallname = respons.getString("HallName");
                        String phone = respons.getString("PhoneNumber");
                        String date = respons.getString("booking_date");
                        listItems.add(new BooksItem(id, name, hallname, phone, date));
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
        final listAdapter lA = new listAdapter(listItems);
        listView.setAdapter(lA);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int which_item = i;
                new AlertDialog.Builder(Books.this)
                        .setIcon(R.drawable.exit)
                        .setTitle("Are You Sure ?")
                        .setMessage("Do you want to Delete this Item")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listItems.remove(which_item);
                                lA.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();


                return true;
            }
        });
    }

    public void call(View view) {
        final TextView callphone = (TextView) findViewById(R.id.textView_phone);
        ImageView call = (ImageView) findViewById(R.id.Call_phone);
        final Intent icall = new Intent(Intent.ACTION_DIAL);
        icall.setData(Uri.parse("tel:" + callphone.getText()));
        startActivity(icall);
    }

    public void SMS(View view) {
        final TextView smsphone = (TextView) findViewById(R.id.textView_phone);
        ImageView call = (ImageView) findViewById(R.id.Call_phone);
        final Intent isms = new Intent(Intent.ACTION_VIEW);
        isms.setData(Uri.parse("sms:" + smsphone.getText()));
        startActivity(isms);

    }

    public void frag(View view) {
        Intent intent = new Intent(Books.this, MainActivity.class);
        startActivity(intent);
    }


    class listAdapter extends BaseAdapter {

        ArrayList<BooksItem> listA = new ArrayList<BooksItem>();

        public listAdapter(ArrayList<BooksItem> listA) {
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
            View view1 = layoutInflater.inflate(R.layout.raw, null);

            TextView id = (TextView) view1.findViewById(R.id.textView_id);
            TextView name = (TextView) view1.findViewById(R.id.textView_name);
            TextView price = (TextView) view1.findViewById(R.id.textView_price);
            TextView phone = (TextView) view1.findViewById(R.id.textView_phone);
            TextView datee = (TextView) view1.findViewById(R.id.date);


            id.setText(listA.get(i).id);
            name.setText(listA.get(i).name);
            price.setText(listA.get(i).hallname);
            phone.setText(listA.get(i).phoneno);
            datee.setText(listA.get(i).date);


            return view1;


        }
    }

}

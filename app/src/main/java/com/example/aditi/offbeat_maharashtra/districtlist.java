package com.example.aditi.offbeat_maharashtra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class districtlist extends AppCompatActivity {
    DrawerLayout draw;
    ListView districtlist;
    FirebaseListAdapter<String> myadapter;
    DatabaseReference districtref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_districtlist);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        districtlist = (ListView)findViewById(R.id.districtlist);
//        draw = (DrawerLayout)findViewById(R.id.nvView);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        districtref = database.getReference(constants.FIREBASE_DISTRICT_LOCATION);
        Log.d("DistrictList", districtref.toString());
        myadapter = new FirebaseListAdapter<String>
                (this,String.class,android.R.layout.simple_list_item_1,districtref) {
            @Override
            protected void populateView(View v, String model, int position) {
                ((TextView) v.findViewById(android.R.id.text1)).setText(model);
        }
        };
        districtlist.setAdapter(myadapter);

        districtlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = myadapter.getRef(position).getKey();
                Intent intent = new Intent(districtlist.this, fortlist.class);
                intent.putExtra(constants.FIRBASE_KEY, key);
                intent.putExtra(constants.FIRBASE_LOCATION_KEY, myadapter.getItem(position));
                startActivity(intent);


            }
        });

    }
}

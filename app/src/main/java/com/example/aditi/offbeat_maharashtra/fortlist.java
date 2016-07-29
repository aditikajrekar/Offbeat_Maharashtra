package com.example.aditi.offbeat_maharashtra;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fortlist extends AppCompatActivity {

    ListView fortlist;
    fort_menu sample;
    FirebaseListAdapter<fort_menu> adapter;
    DatabaseReference fortReference;
    String Location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fortlist = (ListView) findViewById(R.id.fort_list);
        Location = getIntent().getStringExtra(constants.FIRBASE_LOCATION_KEY);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        fortReference = database.getReference(constants.FIREBASE_FORT_LOCATION);
        DatabaseReference districtRef = fortReference.child(Location.toLowerCase());
        Log.d("FortList", districtRef.toString());

        adapter = new FirebaseListAdapter<fort_menu>(this, fort_menu.class,
                R.layout.row_layout, districtRef) {
            @Override
            protected void populateView(View v, fort_menu model, int position) {
                ((TextView) v.findViewById(R.id.fort_name)).setText(model.getName());
            }
        };
        fortlist.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fortlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = adapter.getRef(position).getKey();
                Intent intent = new Intent(fortlist.this, detail.class);
                fort_menu clickeditem = adapter.getItem(position);
                intent.putExtra(constants.FIRBASE_KEY, key);
                Bundle bundle = new Bundle();
                bundle.putSerializable("clicked_item", clickeditem);
                intent.putExtra(constants.FIRBASE_LOCATION_KEY, Location);
                intent.putExtra(constants.FIRBASE_KEY, clickeditem.getName());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

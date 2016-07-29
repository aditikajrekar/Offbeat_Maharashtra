package com.example.aditi.offbeat_maharashtra;

import android.content.Context;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class detail extends AppCompatActivity {
    fort_menu sample;
    TextView fort_title,height,height_details,base_village,base_village_details,vicinity_title,
    vicinity_details,how_to_reach, reach_details,range_title, range_details, history_title,
    history_details,interest_title,interest_details,accomodation_title, accomodation_details;
    ImageView image_fort;
    Context c;
    FloatingActionButton fab;
    String key;
    DatabaseReference fortreference;
    CoordinatorLayout.Behavior<ImageView> behaviour;

    CardView geographical_aspects,places_of_interest,history,accomodation;
    CollapsingToolbarLayout collapsing_layout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initialiseviews();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        fortreference = database.getReference(constants.FIREBASE_FORT_LOCATION);
        String location = getIntent().getStringExtra(constants.FIRBASE_LOCATION_KEY);
        String info = getIntent().getStringExtra(constants.FIRBASE_KEY);
        DatabaseReference inforefrence = fortreference.child(location.toLowerCase()).child(info);
        sample= (fort_menu) getIntent().getExtras().getSerializable("clicked_item");
        fort_title.setText(sample.getName());
    }
    void initialiseviews()
    {
        geographical_aspects = (CardView) findViewById(R.id.geographical_aspects);
        places_of_interest = (CardView) findViewById(R.id.places_of_interest);
        history = (CardView) findViewById(R.id.history);
        accomodation = (CardView) findViewById(R.id.accomodation);
        image_fort = (ImageView)findViewById(R.id.image_fort);
        fort_title = (TextView)findViewById(R.id.fort_title);
        height = (TextView)findViewById(R.id.heigth_title);
        height_details= (TextView)findViewById(R.id.height_details);
        base_village = (TextView)findViewById(R.id.base_village_title);
        base_village_details = (TextView)findViewById(R.id.Base_Village_details);
        vicinity_title = (TextView)findViewById(R.id.vicinity_title);
        vicinity_details = (TextView)findViewById(R.id.vicinity_details);
        how_to_reach = (TextView)findViewById(R.id.how_to_reach_title);
        reach_details = (TextView)findViewById(R.id.reach_details);
        range_title = (TextView)findViewById(R.id.range_title);
        range_details = (TextView)findViewById(R.id.range_details);
        history_title = (TextView)findViewById(R.id.history_title);
        history_details = (TextView)findViewById(R.id.history_details);
        interest_title = (TextView)findViewById(R.id.title_interest);
        interest_details = (TextView)findViewById(R.id.interest_details);
        accomodation_title = (TextView)findViewById(R.id.accomodation_title);
        accomodation_details = (TextView)findViewById(R.id.accomodation_details);
        collapsing_layout = (CollapsingToolbarLayout)findViewById(R.id.collasping_layout);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
    }
}

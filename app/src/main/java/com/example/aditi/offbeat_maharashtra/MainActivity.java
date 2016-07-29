package com.example.aditi.offbeat_maharashtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.aditi.offbeat_maharashtra.R;

public class MainActivity extends AppCompatActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        Button alpa1 = (Button) findViewById(R.id.en_btn);
        Button alpha2 = (Button) findViewById(R.id.mr_btn);

        alpa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha);
                Intent i = new Intent(MainActivity.this,districtlist.class);
                startActivity(i);
            }
        });

        alpha2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha);
            }
        });
    }
}
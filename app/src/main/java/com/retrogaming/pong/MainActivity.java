package com.retrogaming.pong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import com.retrogaming.pong.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();


    }
    protected void setListeners () {


        this.findViewById(R.id.imageView4)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, Pong.class);
                        startActivity(i);
                    }
                });

        this.findViewById(R.id.imageView5)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(MainActivity.this, Construction.class);
                                startActivity(i);
                            }
                        });

        this.findViewById(R.id.imageView6)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, Construction.class);
                        startActivity(i);
                    }
                });

    }



}
package com.retrogaming.pong;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import android.content.Intent;


import android.view.View;
import android.widget.EditText;

/**
 * Created by loic on 12/03/2015.
 */
public class NamePlayer extends Activity {

    //static String player1;// = namePlayer1.getText().toString();
    //static String player2;// = namePlayer2.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);


        //EditText namePlayer1 = (EditText) findViewById(R.id.editText);
        //s.setText(player1);
        //EditText namePlayer2 = (EditText) findViewById(R.id.editText2);
        //player1= namePlayer1.getText().toString();
        //player2= namePlayer2.getText().toString();

        this.findViewById(R.id.button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nbPlayer();
                    }
                });



    }



    protected void nbPlayer() {
        EditText namePlayer1 = (EditText) findViewById(R.id.editText);
        EditText namePlayer2 = (EditText) findViewById(R.id.editText2);
        final String player1 = namePlayer1.getText().toString();
        final String player2 = namePlayer2.getText().toString();
        if (player2.matches("")) {
            this.findViewById(R.id.button)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startGame(false, true, player1,player2);
                        }
                    });
        } else {
            this.findViewById(R.id.button)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startGame(true, true,player1,player2);
                        }
                    });
               }
        }

    protected void startGame(boolean redPlayer, boolean bluePlayer, String player1, String player2) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra(GameActivity.EXTRA_BLUE_PLAYER, bluePlayer);
        i.putExtra(GameActivity.EXTRA_RED_PLAYER, redPlayer);
        i.putExtra(GameActivity.EXTRA_RED_PLAYER_NAME, player2);
        i.putExtra(GameActivity.EXTRA_BLUE_PLAYER_NAME, player1);
        startActivity(i);
    }

    public static final String
            PREF_BALL_SPEED = "ball_speed",
            PREF_STRATEGY = "strategy",
            PREF_LIVES = "lives",
            PREF_HANDICAP = "handicap",
            PREF_MUTED = "muted";

    public static final String
            KEY_AI_STRATEGY = "key_ai_strategy";

}
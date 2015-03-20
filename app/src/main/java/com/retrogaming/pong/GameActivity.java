package com.retrogaming.pong;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {
    public static final String EXTRA_RED_PLAYER_NAME = "red_name";
    public static final String EXTRA_BLUE_PLAYER_NAME = "blue_name" ;
    //    private final MyActivity activity = new MyActivity();
    private PongView mPongView;
	private AlertDialog mAboutBox;
	protected PowerManager.WakeLock mWakeLock;

	public static final String
		EXTRA_RED_PLAYER = "red-is-player",
		EXTRA_BLUE_PLAYER = "blue-is-player";


    public void hideAboutBox() {
    	if(mAboutBox != null) {
    		mAboutBox.hide();
    		mAboutBox = null;
    	}
    }




 //   private class MyActivity extends Activity {
        @Override
        protected void onCreate(Bundle icicle) {
            super.onCreate(icicle);

            requestWindowFeature(Window.FEATURE_NO_TITLE);

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


         //  setContentView(R.layout.pong_view);
        //   mPongView = (PongView) findViewById(R.id.pong);

         //  Intent i = getIntent();
         //  Bundle b = i.getExtras();
         //  mPongView.setPlayerControl(b.getBoolean(EXTRA_RED_PLAYER, false),
         //  b.getBoolean(EXTRA_BLUE_PLAYER, false)
        //   );
        //   mPongView.update();



            this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

            final PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "Pong");
            mWakeLock.acquire();
        }

        protected void onStop() {
            super.onStop();
            mPongView.stop();
        }

        protected void onResume() {
            super.onResume();
            setContentView(R.layout.pong_view);
            mPongView = (PongView) findViewById(R.id.pong);

            Intent i = getIntent();
            Bundle b = i.getExtras();
            mPongView.setPlayerControl(
                    b.getBoolean(EXTRA_RED_PLAYER, false),
                   b.getBoolean(EXTRA_BLUE_PLAYER, false),
                    b.getString(EXTRA_RED_PLAYER_NAME,"name"),
                    b.getString(EXTRA_BLUE_PLAYER_NAME,"name")
           );
           mPongView.update();
        }

        protected void onDestroy() {
            super.onDestroy();
            mPongView.release();
            mWakeLock.release();
        }
 //   }
}
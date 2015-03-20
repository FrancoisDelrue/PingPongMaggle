package com.retrogaming.pong;

        import android.os.Bundle;
        import android.preference.PreferenceActivity;

        import com.retrogaming.pong.R;

public class PongPreferencesActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.preferences);
    }
}
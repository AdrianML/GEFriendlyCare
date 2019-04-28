package mx.itesm.aml.gefc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler = new Handler();
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    mEditor.putBoolean("firstrun", false).commit();
                    Intent intent = new Intent(MainActivity.this, LoginActiv.class);
                    startActivity(intent);

                finish();

            }
        },2000);

    }
}
